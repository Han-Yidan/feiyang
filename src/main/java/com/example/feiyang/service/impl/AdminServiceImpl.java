package com.example.feiyang.service.impl;

import com.example.feiyang.dao.StaffMapper;
import com.example.feiyang.entity.Staff;
import com.example.feiyang.service.AdminService;
import com.example.feiyang.service.ex.InsertException;
import com.example.feiyang.service.ex.NullException;
import com.example.feiyang.service.ex.StaffDuplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 管理员模块业务层的实现类
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public void reg(Long userId) {

        if (userId != null) {
            //调用selectByPrimaryKey(userId)判断技术员是否被注册过
            Staff result = staffMapper.selectByPrimaryKey(userId);
            //判断结果集是否不为null则抛出技术员被注册过的异常
            if (result != null) {
                //抛异常
                throw new StaffDuplicationException("技术员被注册过");
            }


            Staff staff = new Staff();
            //补全数据：userId设置成传入的userId
            staff.setUserId(userId);
            //补全数据：维修和发帖初始化为0,is_allow
            staff.setPostCount(0);
            staff.setRepairCount(0);
            staff.setIsAllow(0);
            //补全数九：维修时间间隔初始化为注册时间
            Date date = new Date();
            staff.setLastTime(date);

            //执行注册业务功能的实现（rows==1）
            Integer rows = staffMapper.insert(staff);
            if (rows != 1) {
                throw new InsertException("用户在注册过程中产生了未知的异常");
            }
        } else {
            throw new NullException("前端传来了一个空值");
        }

    }
}
