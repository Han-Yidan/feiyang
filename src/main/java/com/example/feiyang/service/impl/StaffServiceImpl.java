package com.example.feiyang.service.impl;

import com.example.feiyang.dao.StaffMapper;
import com.example.feiyang.dao.UserMapper;
import com.example.feiyang.entity.Staff;
import com.example.feiyang.entity.StaffExample;
import com.example.feiyang.entity.StaffList;
import com.example.feiyang.entity.User;
import com.example.feiyang.service.StaffService;
import com.example.feiyang.service.ex.InsertException;
import com.example.feiyang.service.ex.NullException;
import com.example.feiyang.service.ex.StaffDuplicationException;
import com.example.feiyang.service.ex.StaffNotFoundException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public Staff reg(Long userId) {

        //调用selectByPrimaryKey(userId)判断技术员是否被注册过
        Staff result = staffMapper.selectByPrimaryKey(userId);
        //判断结果集是否不为null则抛出技术员被注册过的异常
        if (result != null) {
            //抛异常
            throw new StaffDuplicationException("技术员被注册过");
        }

        //判断用户中是否存在该userId
        Staff staff = new Staff();
        User userResult = userMapper.selectByPrimaryKey(userId);
        if (userResult == null) {
            throw new NullException("该用户不存在");
        }

        //将用户的istaff设置为1
        userResult.setIsStaff(1);
        userMapper.updateByPrimaryKeySelective(userResult);
        //补全数据：userId设置成传入的userId
        staff.setUserId(userId);
        //补全数据：维修和发帖初始化为0,允许接单为1，接单间隔初始化为0，order_transfer初始化为1
        staff.setPostCount(0);
        staff.setRepairCount(0);
        staff.setIsAllow(1);
        staff.setReceiveInterval(0);
        staff.setOrderTransfer(1);
        //补全数据：维修时间间隔初始化为注册时间
        Date date = new Date();
        staff.setLastTime(date);

        //执行注册业务功能的实现（rows==1）
        Integer rows = staffMapper.insert(staff);
        if (rows != 1) {
            throw new InsertException("用户在注册过程中产生了未知的异常");
        }
        return staff;
    }

    @Override
    public Staff updateStaff(Long userId, String tips, Integer isAllow, Integer receiveInterval) {

        //技术员原来的数据内容
        Staff preStaff = staffMapper.selectByPrimaryKey(userId);
        if (preStaff == null) {
            throw new StaffNotFoundException("不存在这个技术员");
        }

        //修改技术员简介，是否禁止报修，接单间隔字段
        preStaff.setTips(tips);
        preStaff.setIsAllow(isAllow);
        preStaff.setReceiveInterval(receiveInterval);
        int rows = staffMapper.updateByPrimaryKeySelective(preStaff);

        if (rows != 1) {
            throw new InsertException("修改技术员信息产生了未知的异常");
        }

        return preStaff;
    }

    //技术员按照年份上岗
    @Override
    public Boolean selectYearStaff(String year) {
        StaffExample staffExample = new StaffExample();
        StaffExample.Criteria criteria = staffExample.createCriteria();
        criteria.andIsAllowIsNotNull();
        Staff staff = new Staff();
        staff.setIsAllow(0);
        Integer rows = staffMapper.updateByExampleSelective(staff, staffExample);
        criteria.andYearEqualTo(Integer.parseInt(year));
        staff.setIsAllow(1);
        Integer rows2 = staffMapper.updateByExampleSelective(staff, staffExample);
        return true;
    }

    //按年份查询技术员的姓名，头像，积分
    @Override
    public List selectByYearStaffList(String year, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StaffList> map = staffMapper.selectByYearWithList(Integer.parseInt(year));
        PageInfo<StaffList> pageInfo = new PageInfo(map);
        return pageInfo.getList();
    }

    //按年份查询技术员总数
    @Override
    public Integer getAllStaffs(String year) {
        Integer staffs = staffMapper.selectAllStaffs(Integer.parseInt(year));
        return staffs;
    }

    //获取所有年份
    @Override
    public List<Map<String, Object>> selectYear() {
        List<Map<String, Object>> yearMap = staffMapper.selectYear();
        return yearMap;
    }

    @Override
    public Map<String, Object> selectStaffInfo(Long staffId) {
        if (staffId == null){
            throw new NullException("id为空");
        }else if (staffMapper.selectByPrimaryKey(staffId) == null){
            throw new StaffNotFoundException("技术员不存在");
        }
        return staffMapper.selectStaffInfo(staffId);
    }


}
