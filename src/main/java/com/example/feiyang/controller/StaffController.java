package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Staff;
import com.example.feiyang.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //@Controller+@ResponseBody
@RequestMapping("/staff")
public class StaffController extends BaseController {
    @Autowired
    private StaffService staffService;

    @RequestMapping("/add")
    public JsonResponse<Staff> reg(@RequestParam("userId") Long userId) {
        Staff data = staffService.reg(userId);
        return new JsonResponse<>(OK, data);
    }

    @RequestMapping("/update")
    public JsonResponse<Staff> updateStaff(@RequestParam("userId") Long userId, String tips, Integer isAllow, Integer receiveInterval) {
        Staff data = staffService.updateStaff(userId, tips, isAllow, receiveInterval);
        return new JsonResponse<>(OK, data);
    }

    @RequestMapping("/year")
    public JsonResponse<List> selectYearStaff(@RequestParam String year) {
        List<Staff> data = staffService.selectYearStaff(year);
        return new JsonResponse<>(OK, data);
    }

//    @RequestMapping("/user/update")
//    public JsonResponse<User> modifyUserIsBan(Long userId, Integer isBan) {
//        User data = adminService.modifyUserIsBan(userId, isBan);
//        return new JsonResponse<>(OK, data);
//    }

}