package com.example.feiyang.service;

import com.example.feiyang.entity.Staff;

public interface StaffService {
    /**
     * 技术员注册方法
     *
     * @param userId 技术员的数据对象
     */
    Staff reg(Long userId);

    Staff updateStaff(Long userId, String tips, Integer isAllow, Integer receiveInterval);

//    User modifyUserIsBan(Long userId, Integer isBan);
}
