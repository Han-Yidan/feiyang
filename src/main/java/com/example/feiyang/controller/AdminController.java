package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.Question;
import com.example.feiyang.service.AdminService;
import com.example.feiyang.service.impl.FeedServiceImpl;
import com.example.feiyang.service.impl.QuestionServiceImpl;
import com.example.feiyang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/login")
    public JsonResponse login(String username,String password){
        return adminService.login(username,password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/global")
    public JsonResponse getGlobal() {
        Map<String, Object> res = new HashMap<>();

        res.put("AllUsers", userService.getTotalUser());
        res.put("TotalVips", userService.getTotalVip());
        res.put("TotalQuestion", questionService.getTotalQuestion());
        res.put("TotalFeedback", feedService.getTotalFeed());

        return JsonResponse.success(res, "获取成功！");
    }
}
