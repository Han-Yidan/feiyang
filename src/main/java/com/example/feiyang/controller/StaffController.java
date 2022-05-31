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

    //技术员根据年份上岗，其他年份技术员下岗
    @RequestMapping("/year")
    public JsonResponse<Boolean> selectYearStaff(@RequestParam("year") String year) {
        Boolean data = staffService.selectYearStaff(year);
        return new JsonResponse<>(OK, data);
    }

    //按照年份查询技术员姓名、头像和积分
    @RequestMapping("/yearList")
    public JsonResponse<List> selectByYearList(@RequestParam("year") String year, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        List<Map<String, Object>> data = staffService.selectByYearStaffList(year, pageNum, pageSize);
        return new JsonResponse<>(OK, data);
    }

    //获取年份信息
    @RequestMapping("yearInfo")
    public JsonResponse<List> selectYear() {
        List<Map<String, Object>> data = staffService.selectYear();
        return new JsonResponse<>(OK, data);
    }

    @RequestMapping("/info")
    public JsonResponse selectStaffInfo(Long staffId){
        Map<String, Object> map = staffService.selectStaffInfo(staffId);
        return JsonResponse.success(map);
    }

}