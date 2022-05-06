package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.User;

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
    public boolean init(User user);
}
