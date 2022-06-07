package com.example.feiyang.service.impl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.dao.AdminMapper;
import com.example.feiyang.dao.ConfMapper;
import com.example.feiyang.entity.Admin;
import com.example.feiyang.entity.AdminExample;
import com.example.feiyang.service.AdminService;
import com.example.feiyang.service.ex.InsertException;
import com.example.feiyang.service.ex.UsernameDuplitedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ConfMapper confMapper;

    @Override
    public JsonResponse login(String username, String password) {
        AdminExample ae = new AdminExample();
        AdminExample.Criteria criteria = ae.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Admin> admin = adminMapper.selectByExample(ae);
        if (admin.isEmpty()) return JsonResponse.failure("管理员用户名不存在");
        if (!password.equals(admin.get(0).getPassword())) return JsonResponse.failure("密码错误");
        return JsonResponse.success(admin, "登录成功");
    }

    @Override
    public void reg(Map<String, Object> params) {
        //获取用户名和密码
        String username = params.get("username").toString();
        String password = params.get("password").toString();

        //判断用户名是否已经注册过
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if (!adminList.isEmpty()) {
            throw new UsernameDuplitedException("管理员的用户名被占用");
        }

        //插入用户名和密码
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        //补全数据 createtime
        Date date = new Date();
        admin.setCreatetime(date);
        Integer rows = adminMapper.insert(admin);
        //判断是否出现未知的异常
        if (rows != 1) {
            throw new InsertException("管理员用户注册产生了未知的异常");
        }
    }

    @Override
    public Integer getTotalAdmin() {
        Integer integer = adminMapper.selectTotalAdmin();
        return integer;
    }

}
