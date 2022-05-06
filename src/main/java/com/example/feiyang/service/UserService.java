package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.User;

import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/5 21:21
 */

public interface UserService {
    /**
     * 发送验证码
     * @param phoneNumber
     * @return
     */
    public String sendCode(String phoneNumber);

    /**
     * 用户登录
     * @param phoneNumber
     * @return
     */
    public JsonResponse login(String phoneNumber);

    /**
     * 初始化用户信息，相当于注册功能
     * @param user
     * @return
     */
    public JsonResponse init(User user);

    /**
     * 用户注册vip
     * @param userId
     * @return
     */
    public JsonResponse addVip(Long userId);

    /**
     * 修改用户信息
     * @param params
     * @return
     */
    public JsonResponse updateUser(Map<String, Object> params);
}
