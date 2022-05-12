package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.User;
import com.example.feiyang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/5 11:10
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET, value = "/sendCode")
    @ResponseBody
    public JsonResponse sendCode(@PathParam("phoneNumber") String phoneNumber) {
        Map<String, Object> res = new HashMap<>();
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


        JsonResponse res = userService.init(params);

        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addVip")
    @ResponseBody
    public JsonResponse addVip(@PathParam("user_id") Long user_id) {
        JsonResponse res = userService.addVip(user_id);

        return res;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    @ResponseBody
    public JsonResponse updateUser(@RequestBody Map<String, Object> params) {

        JsonResponse res = userService.updateUser(params);

        return res;
    }

}
