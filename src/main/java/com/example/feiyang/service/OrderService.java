package com.example.feiyang.service;

import com.example.feiyang.entity.Order;

import java.util.List;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-05-05 22:47
 **/

public interface OrderService {
    int addOrder(Order order);
    int cancelOrder(Long orderId,String cancelReason);
    int receiveOrder(Long staffId,Long orderId);
    void assignOrder();
    int assignOrder(Long staffId,Long orderId);
    List<Order> queryAll();
    Order queryOrder(Long orderId);
    int finishOrder(Long orderId);
    int remindOrder(Long orderId);
}
