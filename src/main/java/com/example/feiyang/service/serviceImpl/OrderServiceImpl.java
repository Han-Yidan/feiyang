package com.example.feiyang.service.serviceImpl;

import com.example.feiyang.entity.Order;
import com.example.feiyang.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public int addOrder(Order order) {
        return 0;
    }

    @Override
    public int cancelOrder(Long orderId, String cancelReason) {
        return 0;
    }

    @Override
    public int receiveOrder(Long staffId) {
        return 0;
    }

    @Override
    public int assignOrder(Long staffId) {
        return 0;
    }

    @Override
    public List<Order> queryAll() {
        return null;
    }

    @Override
    public Order queryOrder(Long orderId) {
        return null;
    }

    @Override
    public int finishOrder(Long orderId) {
        return 0;
    }

    @Override
    public int remindOrder(Long orderId) {
        return 0;
    }
}
