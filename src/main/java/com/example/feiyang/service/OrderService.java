package com.example.feiyang.service;

import com.example.feiyang.entity.Order;

import java.util.List;

public interface OrderService {
    int addOrder(Order order);
    int cancelOrder(Long orderId,String cancelReason);
    int receiveOrder(Long staffId);
    int assignOrder(Long staffId);
    List<Order> queryAll();
    Order queryOrder(Long orderId);
    int finishOrder(Long orderId);
    int remindOrder(Long orderId);
}
