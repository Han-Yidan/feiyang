package com.example.feiyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired

    @RequestMapping("/order/add")
    public int addOrder(){
        return 0;
    }
}
