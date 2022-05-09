package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller+@ResponseBody
@RequestMapping("/staff")
public class AdminController extends BaseController {
    @Autowired
    private AdminService staffService;

    @RequestMapping("/add")
    public JsonResponse<Void> reg(Long userId) {
        staffService.reg(userId);
        return new JsonResponse<>(OK);
    }
}
