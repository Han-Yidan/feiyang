package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.AdminService;
import com.example.feiyang.service.OrderService;
import com.example.feiyang.service.StaffService;
import com.example.feiyang.service.impl.FeedServiceImpl;
import com.example.feiyang.service.impl.QuestionServiceImpl;
import com.example.feiyang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController //@Controller+@ResponseBody
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private QuestionServiceImpl questionService;
    @Autowired
    private FeedServiceImpl feedService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StaffService staffService;

    @RequestMapping("/login")
    public JsonResponse login(String username, String password) {
        return adminService.login(username, password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/global")
    public JsonResponse getGlobal(@RequestParam("year") String year) {
        Map<String, Object> res = new HashMap<>();

        res.put("AllUsers", userService.getTotalUser());
        res.put("TotalVips", userService.getTotalVip());
        res.put("TotalQuestion", questionService.getTotalQuestion());
        res.put("TotalFeedback", feedService.getTotalFeed());
        res.put("TodayOrder", orderService.getTodayOrder());
        res.put("ThisWeek", orderService.getThisWeek());
        res.put("ThisMonth", orderService.getThisMonth());
        res.put("TotalOrder", orderService.getTotalOrder());
        res.put("ALLStaffs", staffService.getAllStaffs(year));
        res.put("TotalAdmin", adminService.getTotalAdmin());

        return JsonResponse.success(res, "获取成功！");
    }

    @RequestMapping("/queryOrder")
    public JsonResponse queryOrder(String repairType,Integer status,String staffName,String userName,int current){
        return orderService.queryOrderForAdmin(repairType, status, staffName, userName,current);
    }

    /**
     * 管理员用户注册
     *
     * @param params
     * @return
     */
    @RequestMapping("reg")
    public JsonResponse<Void> reg(@RequestBody Map<String, Object> params) {
        adminService.reg(params);
        return new JsonResponse<>(OK);
    }


}
