package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller+@ResponseBody
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public JsonResponse login(String username,String password){
        return adminService.login(username,password);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/global")
//    public JsonResponse getGlobal() {
//
//    }
}
