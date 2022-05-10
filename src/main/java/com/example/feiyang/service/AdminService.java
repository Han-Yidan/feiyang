package com.example.feiyang.service;

import com.example.feiyang.entity.Staff;
import com.example.feiyang.entity.User;

/**
 * 管理员模块业务层接口
 */
public interface AdminService {
    /**
     * 技术员注册方法
     *
     * @param userId 技术员的数据对象
     */
    Staff reg(Long userId);

    Staff updateStaff(Long userId, String tips, Integer isAllow, Integer receiveInterval);

    User modifyUserIsBan(Long userId, Integer isBan);
}
