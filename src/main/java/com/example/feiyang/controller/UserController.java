package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/5 11:10
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET, value = "/sendCode")
    public JsonResponse sendCode(@PathParam("phoneNumber") String phoneNumber) {
        Map<String, Object> res = new HashMap<>();
        String code = userService.sendCode(phoneNumber);

        res.put("isSend", 1);
        res.put("code", code);

        return JsonResponse.success(res, "发送成功！");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public JsonResponse login(@RequestBody Map<String, Object> params) {
        String phoneNumber = (String) params.get("phoneNumber");
        JsonResponse res = userService.login(phoneNumber);

        return res;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/init")
    public JsonResponse init(@RequestBody Map<String, Object> params) {


        JsonResponse res = userService.init(params);

        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addVip")
    public JsonResponse addVip(@PathParam("user_id") Long user_id) {
        JsonResponse res = userService.addVip(user_id);

        return res;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateVip")
    public JsonResponse updateVip(@RequestBody Map<String, Object> params) {

        JsonResponse res = userService.updateVip(params);

        return res;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public JsonResponse updateUser(@RequestBody Map<String, Object> params) {

        JsonResponse res = userService.updateUser(params);

        return res;
    }

    /**
     * 查询所有用户（普通用户或者技术员、管理员）
     */
    @RequestMapping("/all")
    public JsonResponse queryAll(int role){
        return userService.queryAll(role);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserInfo")
    public JsonResponse getUserInfo(@PathParam("user_id") Long user_id) {
        return userService.getUserInfo(user_id);
    }
}
