package com.example.feiyang.service;


import com.example.feiyang.common.utils.JsonResponse;

import java.util.Map;

/**
 * @author hyd
 */
public interface AdminService {
    JsonResponse login(String username, String password);

    /**
     * 管理员注册
     *
     * @param params
     */
    void reg(Map<String, Object> params);

    /**
     * 返回所有管理员总数
     *
     * @return
     */
    Integer getTotalAdmin();

}
