package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;

/**
 * @author 望舒
 * @date 2022/5/5 21:21
 */

public interface UserService {
    public JsonResponse login(String phoneNumber);
}
