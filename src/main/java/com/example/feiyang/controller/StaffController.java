package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Staff;
import com.example.feiyang.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController //@Controller+@ResponseBody
@RequestMapping("/staff")
public class StaffController extends BaseController {
    @Autowired
    private StaffService staffService;

    //--也可以改成改变isStaff可以实现技术员变回用户
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
    public JsonResponse<List> selectYearStaff(@RequestParam("year") String year) {
        List<Staff> data = staffService.selectYearStaff(year);
        return new JsonResponse<>(OK, data);
    }

    //根据年份返回
    @RequestMapping("/yearList")
    public JsonResponse<List> selectByYearList(@RequestParam("year") String year, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        List<Map<String, Object>> data = staffService.selectByYearStaffList(year, pageNum, pageSize);
        return new JsonResponse<>(OK, data);
    }

    //返回技术员总数
    @RequestMapping("/allStaffs")
    public JsonResponse allStaffs() {
        Integer data = staffService.allStaffs();
        return new JsonResponse<>(OK, data);
    }

}