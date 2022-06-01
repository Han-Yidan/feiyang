package com.example.feiyang.service.impl;

import com.example.feiyang.common.utils.FileUtils;
import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.common.utils.MessageUtils;
import com.example.feiyang.dao.OrderMapper;
import com.example.feiyang.dao.StaffMapper;
import com.example.feiyang.dao.UserMapper;
import com.example.feiyang.entity.*;
import com.example.feiyang.service.OrderService;
import com.example.feiyang.service.ex.NullException;
import com.example.feiyang.service.ex.StaffNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-05-05 22:46
 **/


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private UserMapper userMapper;

    private static final Long HOUR = (long)60*60*1000;

    private static volatile LinkedHashMap<Long,Order> waitingOrders;
    @Autowired
    public void setWaitingOrders(){
        System.out.println("初始化waiting orders");
        waitingOrders = new LinkedHashMap<>();
        OrderExample oe = new OrderExample();
        OrderExample.Criteria criteria = oe.createCriteria();
        criteria.andStatusEqualTo(1);
        List<Order> orders = orderMapper.selectByExample(oe);
        for(Order order:orders){
            waitingOrders.put(order.getOrderId(),order);
        }
        if (!waitingOrders.isEmpty()){
            new Thread(()->{
                assignOrder();
            }).start();
        }
    }

    @Override
    public JsonResponse addOrder(Map<String,Object> map) {
        Order order = new Order();
        order.setUserId(Long.valueOf((String)map.get("userId")));
        order.setDeviceType((String) map.get("deviceType"));
        order.setDeviceBrand((String) map.get("deviceBrand"));
        order.setDeviceVersion((String) map.get("deviceVersion"));
        order.setGuaranteeStatus((String) map.get("guaranteeStatus"));
        order.setRepairType((String) map.get("repairType"));
        order.setRepairInstruction((String) map.get("repairInstruction"));
        order.setRepairImage((String) map.get("repairImage"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date buyTime = null;
        try {
            buyTime = format.parse((String)map.get("buyTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setBuyTime(buyTime);
        order.setCreateTime(new Date());
        order.setStatus(1);
        int result = orderMapper.insert(order);
        waitingOrders.put(order.getOrderId(),order);
        if(waitingOrders.size() == 1){
            new Thread(()->{
                assignOrder();
            }).start();
        }
        if(result == 1){
            return JsonResponse.success(order,"报修成功");
        }else {
            return JsonResponse.failure("报修失败");
        }
    }

    @Override
    public JsonResponse cancelOrder(Map<String,Object> map) {
        //更新订单状态
        Long orderId = Long.valueOf((String)map.get("orderId"));
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            return JsonResponse.failure("订单号不存在");
        }else if (order.getStatus() == 0){
            return JsonResponse.failure("该订单已经取消，请勿重复操作");
        }
        Long staffId = order.getStaffId();
        order.setCancelReason((String)map.get("cancelReason"));
        order.setStatus(0);
        order.setCloseTime(new Date());
        int result1 = orderMapper.updateByPrimaryKeySelective(order);
        //更新技术员状态
        if (staffId != null){
            Staff staff = new Staff();
            staff.setUserId(staffId);
            staff.setIsAllow(1);
            result1 &= staffMapper.updateByPrimaryKeySelective(staff);
        }
        if(waitingOrders.containsKey(orderId)) waitingOrders.remove(orderId);
        if(result1 == 1) {
            return JsonResponse.success(order,"取消成功");
        }else{
            return JsonResponse.failure("取消失败");
        }
    }

    @Override
    public JsonResponse receiveOrder(Long staffId,Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            return JsonResponse.failure("订单号不存在");
        }
        //更新订单状态
        order.setStaffId(staffId);
        order.setStatus(2);
        order.setReceiveTime(new Date());
        int result1 = orderMapper.updateByPrimaryKeySelective(order);
        //更新技术员状态
        Staff currStaff = new Staff();
        currStaff.setUserId(staffId);
        currStaff.setIsAllow(0);
        int result2 = staffMapper.updateByPrimaryKeySelective(currStaff);
        //发送短信提醒技术员有新订单
        User curr = userMapper.selectByPrimaryKey(staffId);
        MessageUtils messageUtils = new MessageUtils();
        messageUtils.sendMessage(curr.getPhoneNumber(),curr.getUsername());
        if(result1 == 1 && result2 == 1) return JsonResponse.success(order,"技术员已成功接单");
        return JsonResponse.failure("技术员未能成功接单");
    }

    public void assignOrder(){
        System.out.println("进入自动分配");
        synchronized (waitingOrders){
            while (!waitingOrders.isEmpty()){
                List<Staff> staff = searchAvailableStaff();
                while(staff.isEmpty()){
                    System.out.println("当前无空闲技术员，请稍后");
                    try {
                        waitingOrders.wait((long)(0.5*HOUR));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    staff = searchAvailableStaff();
                }

                Long staffId = pickOneStaff(staff).getUserId();
                Long orderId = waitingOrders.keySet().iterator().next();
                waitingOrders.remove(orderId);
                receiveOrder(staffId,orderId);
                System.out.println(staffId+"将要负责"+orderId+"号订单");
            }
        }
    }
    @Override
    public int assignOrder(Long staffId,Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            throw new IllegalArgumentException("订单号不存在");
        }
        Staff currStaff = staffMapper.selectByPrimaryKey(staffId);
        if (currStaff == null){
            throw new StaffNotFoundException("技术员不存在");
        }
        int number = currStaff.getOrderTransfer();
        if(number<1){
            System.out.println("转让次数不足，无法转让");
            return -1;
        }
        //将当前技术员转让次数-1
        currStaff.setOrderTransfer(--number);
        currStaff.setIsAllow(1);

        //得到除当前技术员之外的所有空闲技术员
        List<Staff> staff = searchAvailableStaff(staffId);
        //随机选一名空闲技术员
        Staff nextStaff = pickOneStaff(staff);
        //修改订单和技术员状态
        receiveOrder(nextStaff.getUserId(),orderId);
        return staffMapper.updateByPrimaryKeySelective(currStaff);
    }


    @Override
    public JsonResponse queryOrder(Long userId,int current) {
        Page page = new Page();
        page.setRows(queryOrderRows(userId));
        page.setCurrent(current);
        List<Map<String,Object>> map = null;
        if (getRole(userId)<1){
            map = orderMapper.selectAll(userId,null,page.getOffset(),page.getLimit());
        }else{
            map = orderMapper.selectAll(null,userId,page.getOffset(),page.getLimit());
        }
        return JsonResponse.success(map).addOtherData("page",page);
    }

    @Override
    public JsonResponse queryOrderForAdmin(String repairType, Integer status, String staffName, String userName,int current) {
        Page page = new Page();
        page.setCurrent(current);
        page.setRows(queryOrderRowsForAdmin(repairType,status,staffName,userName));

        List<Map<String,Object>> map = orderMapper.selectForAdmin(repairType,status,staffName,userName, page.getOffset(), page.getLimit());
        return JsonResponse.success(map).addOtherData("page",page);
    }

    @Override
    public JsonResponse finishOrder(Long orderId) {
        //更新订单信息
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            return JsonResponse.failure("订单号不存在");
        }else if (order.getStatus() != 2){
            return JsonResponse.failure("订单已完成或被取消");
        }
        order.setStatus(3);
        Date now = new Date();
        order.setCloseTime(now);
        int result1 =  orderMapper.updateByPrimaryKeySelective(order);
        //更新技术员信息
        Long staffId = order.getStaffId();
        Staff staff = staffMapper.selectByPrimaryKey(staffId);
        int repairCount = staff.getRepairCount();
        int score = staff.getScore();
        staff.setLastTime(now);
        long interval = staff.getReceiveInterval()*HOUR;
        long next = now.getTime()+interval;
        staff.setNextTime(new Date(next));
        staff.setUserId(staffId);
        staff.setIsAllow(1);
        staff.setRepairCount(repairCount+1);
        staff.setScore(score+2);
        int result2 = staffMapper.updateByPrimaryKeySelective(staff);

        synchronized (waitingOrders){
            waitingOrders.notifyAll();
        }
        if(result1 == 1 && result2 == 1) return JsonResponse.success(order,"订单已正常结束");
        return JsonResponse.failure("订单未能正常结束");
    }

    @Override
    public int remindOrder(Long orderId) {
        return 0;
    }

    @Override
    public JsonResponse uploadFile(MultipartFile file) throws UnknownHostException, FileNotFoundException {
        FileUtils fileUtils = new FileUtils();
        return fileUtils.uploadFile(file);
    }

    /**
     * 如果是普通用户，返回等待中和进行中的订单
     * 如果是技术员，返回进行中的订单
     * @param userId
     * @return
     */
    @Override
    public List<Order> searchDoingOrder(Long userId){
        OrderExample oe = new OrderExample();
        OrderExample.Criteria criteria = oe.createCriteria();
        if (getRole(userId) == -1){
          return null;
        } else if (getRole(userId) == 0){
            criteria.andUserIdEqualTo(userId);
            criteria.andStatusBetween(1,2);
        }else{
            criteria.andStaffIdEqualTo(userId);
            criteria.andStatusEqualTo(2);
        }
        return orderMapper.selectByExample(oe);
    }

    /**
     * 获取今日订单数量
     * @return
     */
    @Override
    public int getTodayOrder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = sdf.format(date);
        String start = today+" 00:00:00";
        String end = today+" 23:59:59";
        return orderMapper.getSomeRows(start,end);
    }

    @Override
    public int getThisWeek() {
        Calendar cld = getNow();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cld.set(Calendar.DAY_OF_WEEK, 0);
        String end = sdf.format(cld.getTime());
        cld.set(Calendar.DAY_OF_WEEK,1);
        String start = sdf.format(cld.getTime());
        return orderMapper.getSomeRows(start,end);
    }

    @Override
    public int getThisMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cld = getNow();
        //月份+1，天设置为0。下个月第0天，就是这个月最后一天
        cld.add(Calendar.MONTH, 1);
        cld.set(Calendar.DAY_OF_MONTH, 0);
        String end = sdf.format(cld.getTime());
        cld.set(Calendar.DAY_OF_MONTH,1);
        String start = sdf.format(cld.getTime());
        return orderMapper.getSomeRows(start,end);
    }

    @Override
    public int getTotalOrder() {
        return orderMapper.getSomeRows(null,null);
    }

    public int queryOrderRows(Long userId){
        if (getRole(userId)<1) return orderMapper.selectOrderRows(userId,null);
        return orderMapper.selectOrderRows(null,userId);
    }
    public int queryOrderRowsForAdmin(String repairType, Integer status, String staffName, String userName){
        return orderMapper.queryOrderRowsForAdmin(repairType, status, staffName, userName);
    }

    public List<Staff> searchAvailableStaff(){
        StaffExample se = new StaffExample();
        StaffExample.Criteria criteria1 = se.createCriteria();
        StaffExample.Criteria criteria2 = se.createCriteria();
        criteria1.andIsAllowEqualTo(1).andNextTimeIsNull();
        criteria2.andIsAllowEqualTo(1).andNextTimeLessThanOrEqualTo(new Date());
        se.or(criteria2);
        return staffMapper.selectByExample(se);
    }
    public List<Staff> searchAvailableStaff(Long staffId){
        StaffExample se = new StaffExample();
        StaffExample.Criteria criteria1 = se.createCriteria();
        StaffExample.Criteria criteria2 = se.createCriteria();
        criteria1.andIsAllowEqualTo(1).andNextTimeIsNull().andUserIdNotEqualTo(staffId);
        criteria2.andIsAllowEqualTo(1).andNextTimeLessThanOrEqualTo(new Date()).andUserIdNotEqualTo(staffId);
        se.or(criteria2);
        return staffMapper.selectByExample(se);
    }

    /**
     * 随机从空闲技术员中选择一个分配订单
     * @param staff
     * @return
     */
    public Staff pickOneStaff(List<Staff> staff){
        int size = staff.size();
        int option = (int)Math.random()*size;
        return staff.get(option);
    }
    public int getRole(Long userId){
        if(userId == null) return -1;
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) return -1;
        return user.getIsStaff();
    }
    public Calendar getNow(){
        Date date = new Date();
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld;
    }
}

