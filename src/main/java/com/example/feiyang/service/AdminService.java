package com.example.feiyang.service;


import com.example.feiyang.common.utils.JsonResponse;


public interface AdminService {
    JsonResponse login(String username, String password);

    //返回所有管理员总数
    Integer totalAdmin();
}
