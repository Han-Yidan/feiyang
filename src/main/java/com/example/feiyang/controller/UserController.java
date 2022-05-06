package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.User;
import com.example.feiyang.service.serviceImpl.UserServiceImpl;
import com.tencentcloudapi.tcb.v20180608.models.ObjectKV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/5 11:10
 */

@Controller
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET, value = "/sendCode")
    @ResponseBody
    public JsonResponse sendCode(@RequestBody Map<String, Object> params) {
        Map<String, Object> res = new HashMap<>();
        String phoneNumber = (String) params.get("phoneNumber");
        String code = userService.sendCode(phoneNumber);

        res.put("isSend", 1);
        res.put("code", code);

        return JsonResponse.success(res, "发送成功！");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public JsonResponse login(@RequestBody Map<String, Object> params) {
        String phoneNumber = (String) params.get("phoneNumber");
        JsonResponse res = userService.login(phoneNumber);
        
        return res;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/init")
    @ResponseBody
    public JsonResponse init(@RequestBody Map<String, Object> params) {
        User user = new User();
        String username = (String) params.get("username");
        String qqNumber = (String) params.get("qqNumber");
        String phoneNumber = (String) params.get("phoneNumber");
        String email = (String) params.get("email");
        String avatarUrl = (String) params.get("avatarUrl");

        user.setUsername(username);
        user.setQqNumber(qqNumber);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setAvatarUrl(avatarUrl);
        user.setIsVip(0);
        user.setIsBan(0);
        user.setInit(1);
        user.setIsStaff(0);     // 默认为普通用户，技术员需要管理员分配
        user.setCreateTime(new Date());

        boolean isInit = userService.init(user);
        Map<String, Integer> res = new HashMap<>();
        if (isInit) {
            res.put("isInit", 1);
        } else {
            res.put("isInit", 0);
        }

        return JsonResponse.success(res);
    }

}
