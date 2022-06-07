package com.example.feiyang.service;

import com.example.feiyang.entity.Staff;

import java.util.List;
import java.util.Map;

public interface StaffService {
    /**
     * 技术员注册方法
     *
     * @param userId 技术员的数据对象
     */
    Staff reg(Long userId);

    /**
     * 更新技术员信息
     *
     * @param userId
     * @param tips
     * @param isAllow
     * @param receiveInterval
     * @return
     */
    Staff updateStaff(Long userId, String tips, Integer isAllow, Integer receiveInterval);

    /**
     * 按届设置上下岗技术员
     *
     * @param year
     * @return
     */
    Boolean selectYearStaff(String year);

    /**
     * 按届查询技术员姓名、头像、积分
     *
     * @param year
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> selectByYearStaffList(String year, Integer pageNum, Integer pageSize);

    /**
     * 返回总用户数
     *
     * @param year
     * @return
     */
    Integer getAllStaffs(String year);

    /**
     * 返回年份信息
     *
     * @return
     */
    List<Map<String, Object>> selectYear();

    /**
     * 根据staffId返回技术员
     *
     * @param staffId
     * @return
     */
    Map<String, Object> selectStaffInfo(Long staffId);

}
