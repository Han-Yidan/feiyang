package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Staff;
import com.example.feiyang.entity.User;
import com.example.feiyang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller+@ResponseBody

public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/staff/add")
    public JsonResponse<Staff> reg(Long userId) {
        Staff data = adminService.reg(userId);
        return new JsonResponse<>(OK, data);
    }

    @RequestMapping("/staff/update")
    public JsonResponse<Staff> updateStaff(Long userId, String tips, Integer isAllow, Integer receiveInterval) {
        Staff data = adminService.updateStaff(userId, tips, isAllow, receiveInterval);
        return new JsonResponse<>(OK, data);
    }

//    @RequestMapping("/user/update")
//    public JsonResponse<User> modifyUserIsBan(Long userId, Integer isBan) {
//        User data = adminService.modifyUserIsBan(userId, isBan);
//        return new JsonResponse<>(OK, data);
//    }

}
