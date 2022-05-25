package com.example.feiyang.service;

import com.example.feiyang.entity.Staff;

import java.util.List;

public interface StaffService {
    /**
     * 技术员注册方法
     *
     * @param userId 技术员的数据对象
     */
    Staff reg(Long userId);

    Staff updateStaff(Long userId, String tips, Integer isAllow, Integer receiveInterval);

    List<Staff> selectYearStaff(String year);
//    User modifyUserIsBan(Long userId, Integer isBan);
}
