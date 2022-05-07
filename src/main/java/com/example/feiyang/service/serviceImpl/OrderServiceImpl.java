package com.example.feiyang.service.serviceImpl;

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
    public String addOrder(Order order) {
        order.setCreateTime(new Date());
        order.setStatus(1);
        int result = orderMapper.insert(order);
        waitingOrders.put(order.getOrderId(),order);
        if(waitingOrders.size() == 1){
            new Thread(()->{
                assignOrder();
            }).start();
        }
        if(result == 1) return "报修成功";
        return "报修失败";
    }

    @Override
    public String cancelOrder(Long orderId, String cancelReason) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCancelReason(cancelReason);
        order.setStatus(0);
        order.setCloseTime(new Date());
        if(waitingOrders.containsKey(orderId)) waitingOrders.remove(orderId);
        int result = orderMapper.updateByPrimaryKeySelective(order);
        if(result == 1) return "取消成功";
        return "取消失败";
    }

    @Override
    public int receiveOrder(Long staffId,Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStaffId(staffId);
        order.setStatus(2);
        order.setReceiveTime(new Date());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void assignOrder(){
        System.out.println("进入自动分配");
        synchronized (waitingOrders){
            while (!waitingOrders.isEmpty()){
                StaffExample se = new StaffExample();
                StaffExample.Criteria criteria = se.createCriteria();
                criteria.andIsAllowEqualTo(1);
                List<Staff> staff = staffMapper.selectByExample(se);
                while(staff.isEmpty()){
                    System.out.println("当前无空闲技术员，请稍后");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    staff = staffMapper.selectByExample(se);
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

    @Override
    public List<Order> queryAll() {
        OrderExample oe = new OrderExample();

        return orderMapper.selectByExample(oe);
    }

    @Override
    public List<Order> queryOrder(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        OrderExample oe = new OrderExample();
        OrderExample.Criteria criteria = oe.createCriteria();
        if(user.getIsStaff() == 0){
            criteria.andUserIdEqualTo(userId);
        }else{
            criteria.andStaffIdEqualTo(userId);
        }
        return orderMapper.selectByExample(oe);
    }

    @Override
    public int finishOrder(Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStatus(3);
        order.setCloseTime(new Date());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int remindOrder(Long orderId) {
        return 0;
    }
}

