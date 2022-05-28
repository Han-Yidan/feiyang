package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.OrderService;
import com.example.feiyang.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

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
    public JsonResponse addOrder(@RequestBody Map<String,Object> params){
        return orderService.addOrder(params);
    }

    @RequestMapping("/cancel")
    public JsonResponse cancelOrder(@RequestBody Map<String,Object> params){
        return orderService.cancelOrder(params);
    }
    @RequestMapping("/receive")
    public JsonResponse receiveOrder(Long staffId,Long orderId){
        return orderService.receiveOrder(staffId,orderId);
    }
    @RequestMapping("/assign")
    public int assignOrder(Long staffId,Long orderId){
        return orderService.assignOrder(staffId,orderId);
    }

    @RequestMapping("/query")
    public JsonResponse queryOrder(Long userId,int current){
        return orderService.queryOrder(userId,current);
    }

    @RequestMapping("/finish")
    public JsonResponse finishOrder(Long orderId){
        return orderService.finishOrder(orderId);
    }
//    @RequestMapping("/remind")
//    public int remindOrder(Long orderId){
//        return orderService.remindOrder(orderId);
//    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile")
    public JsonResponse uploadFile(@RequestBody MultipartFile file) throws IOException {
//        System.out.println(params.get("fileName"));
        System.out.println(file.getOriginalFilename());
        return orderService.uploadFile(file);
    }


}