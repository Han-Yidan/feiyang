package com.example.feiyang.service.impl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.dao.OrderMapper;
import com.example.feiyang.dao.StaffMapper;
import com.example.feiyang.dao.UserMapper;
import com.example.feiyang.entity.*;
import com.example.feiyang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public JsonResponse addOrder(Order order) {
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
    public JsonResponse cancelOrder(Long orderId, String cancelReason) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCancelReason(cancelReason);
        order.setStatus(0);
        order.setCloseTime(new Date());
        if(waitingOrders.containsKey(orderId)) waitingOrders.remove(orderId);
        int result = orderMapper.updateByPrimaryKeySelective(order);
        if(result == 1) {
            return JsonResponse.success(order,"取消成功");
        }else{
            return JsonResponse.failure("取消失败");
        }
    }

    @Override
    public JsonResponse receiveOrder(Long staffId,Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStaffId(staffId);
        order.setStatus(2);
        order.setReceiveTime(new Date());
        int result = orderMapper.updateByPrimaryKeySelective(order);
        if(result == 1) return JsonResponse.success(order,"技术员已成功接单");
        return JsonResponse.failure("技术员未能成功接单");
    }

    @Override
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
                int size = staff.size();
                int option = (int)Math.random()*size;
                Long staffId = staff.get(option).getUserId();
                Long orderId = waitingOrders.keySet().iterator().next();
                waitingOrders.remove(orderId);
                receiveOrder(staffId,orderId);
                System.out.println(staffId+"将要负责"+orderId+"号订单");
                Staff currStaff = new Staff();
                currStaff.setUserId(staffId);
                currStaff.setIsAllow(0);
                staffMapper.updateByPrimaryKeySelective(currStaff);
            }
        }
    }
    @Override
    public int assignOrder(Long staffId,Long orderId) {
        Staff currStaff = staffMapper.selectByPrimaryKey(staffId);
        int number = currStaff.getOrderTransfer();
        if(number<1){
            System.out.println("转让次数不足，无法转让");
            return -1;
        }
        Staff currStaff1 = new Staff();
        currStaff1.setUserId(staffId);
        currStaff1.setOrderTransfer(--number);
        staffMapper.updateByPrimaryKeySelective(currStaff1);
        StaffExample se = new StaffExample();
        StaffExample.Criteria criteria = se.createCriteria();
        criteria.andIsAllowEqualTo(1);
        criteria.andUserIdNotEqualTo(staffId);
        List<Staff> staff = staffMapper.selectByExample(se);
        int size = staff.size();
        int option = (int)Math.random()*size;
        Long nextStaffId = staff.get(option).getUserId();
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStaffId(nextStaffId);
        return orderMapper.updateByPrimaryKeySelective(order);
    }


    public JsonResponse queryAll() {
        OrderExample oe = new OrderExample();
        List<Order> orders= orderMapper.selectByExample(oe);
        return JsonResponse.success(orders);
    }

    @Override
    public JsonResponse queryOrder(Long userId,int current) {
        Page page = new Page();
        page.setRows(queryOrderRows(userId));
        page.setCurrent(current);
        List<Order> orders = null;
        if (getRole(userId)<1){
            orders = orderMapper.selectAll(userId,null,page.getOffset(),page.getLimit());
        }else{
            orders = orderMapper.selectAll(null,userId,page.getOffset(),page.getLimit());
        }
        return JsonResponse.success(orders).addOtherData("page",page);
    }

    @Override
    public JsonResponse finishOrder(Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStatus(3);
        Date now = new Date();
        order.setCloseTime(now);
        int result =  orderMapper.updateByPrimaryKeySelective(order);
        order = orderMapper.selectByPrimaryKey(orderId);
        Long staffId = order.getStaffId();
        Staff staff = staffMapper.selectByPrimaryKey(staffId);
        staff.setLastTime(now);
        long interval = staff.getReceiveInterval()*HOUR;
        long next = now.getTime()+interval;
        staff.setNextTime(new Date(next));
        staff.setUserId(staffId);
        staff.setIsAllow(1);
        staffMapper.updateByPrimaryKeySelective(staff);
        synchronized (waitingOrders){
            waitingOrders.notifyAll();
        }
        if(result == 1) return JsonResponse.success(order,"订单已正常结束");
        return JsonResponse.failure("订单未能正常结束");
    }

    @Override
    public int remindOrder(Long orderId) {
        return 0;
    }

    public int queryOrderRows(Long userId){
        if (getRole(userId)<1) return orderMapper.selectOrderRows(userId,null);
        return orderMapper.selectOrderRows(null,userId);
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

    public int getRole(Long userId){
        if(userId == null) return -1;
        return userMapper.selectByPrimaryKey(userId).getIsStaff();
    }
}

