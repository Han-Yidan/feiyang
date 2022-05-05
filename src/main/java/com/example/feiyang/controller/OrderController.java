package com.example.feiyang.controller;

import com.example.feiyang.entity.Order;
import com.example.feiyang.service.OrderService;
import com.example.feiyang.service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-05-05 22:48
 **/

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService = new OrderServiceImpl();

    @RequestMapping("/add")
    public int addOrder(Order order){
        System.out.println(order);
        return orderService.addOrder(order);
    }

    @RequestMapping("/cancel")
    public int cancelOrder(Long orderId,String cancelReason){
        return orderService.cancelOrder(orderId,cancelReason);
    }
    @RequestMapping("/receive")
    public int receiveOrder(Long staffId,Long orderId){
        return orderService.receiveOrder(staffId,orderId);
    }
    @RequestMapping("/assign")
    public int assignOrder(Long staffId,Long orderId){
        return orderService.assignOrder(staffId,orderId);
    }
    @RequestMapping("/all")
    public List<Order> queryAll(){
        return orderService.queryAll();
    }
    @RequestMapping("/query")
    public Order queryOrder(Long orderId){
        return orderService.queryOrder(orderId);
    }
    @RequestMapping("/finish")
    public int finishOrder(Long orderId){
        return orderService.finishOrder(orderId);
    }
    @RequestMapping("/remind")
    public int remindOrder(Long orderId){
        return orderService.remindOrder(orderId);
    }
}