package com.example.feiyang.service;


import com.example.feiyang.common.utils.JsonResponse;

import java.util.Map;


public interface AdminService {
    JsonResponse login(String username, String password);

    void reg(Map<String, Object> params);

    //返回所有管理员总数
    Integer getTotalAdmin();
}
