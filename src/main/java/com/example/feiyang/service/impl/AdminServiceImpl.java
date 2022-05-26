package com.example.feiyang.service.impl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.dao.AdminMapper;
import com.example.feiyang.entity.Admin;
import com.example.feiyang.entity.AdminExample;
import com.example.feiyang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

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
    public Integer totalAdmin() {
        Integer integer = adminMapper.selectTotalAdmin();
        return integer;
    }
}
