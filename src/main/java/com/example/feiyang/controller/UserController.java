package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/5 11:10
 */

@Controller
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public JsonResponse login(@RequestBody Map<String, Object> params) {
        String phoneNumber = (String) params.get("phoneNumber");
        return new JsonResponse();
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.login("13408177059");
    }
}
