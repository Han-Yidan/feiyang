package com.example.feiyang.service.impl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.common.utils.MessageUtils;
import com.example.feiyang.common.utils.ValidateCode;
import com.example.feiyang.dao.*;
import com.example.feiyang.entity.*;
import com.example.feiyang.service.OrderService;
import com.example.feiyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 望舒
 * @date 2022/5/5 10:12
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ConfMapper confMapper;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String sendCode(String phoneNumber) {

        // 1. 发送短信验证码
        // 随机验证码
        int vode = ValidateCode.generateValidateCode(6);
        String code = String.valueOf(vode);

        /**
         * 不考虑发送失败的情况
         * 因为前端限制只能60秒点一次
         */
        MessageUtils messageUtils = new MessageUtils();
        messageUtils.sendMessage(phoneNumber, code);

        // 返回给前端验证码，方便前端直接验证
        return code;
    }

    @Override
    public JsonResponse login(String phoneNumber) {
        Map<String, Object> res = new HashMap<>();

        // 2. 判断user表中是否存在该手机号
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneNumberEqualTo(phoneNumber);
        List<User> users = userMapper.selectByExample(userExample);

        // 3. 不存在则添加
        if (users == null) {
            User user = new User();
            user.setPhoneNumber(phoneNumber);
            user.setInit(0);
            userMapper.insert(user);

            // isInit为0，表示还未初始化，需要用户初始化信息
            res.put("isInit", 0);
            // 直接返回初始化页面
            return JsonResponse.success(res, "未初始化");
        }

        // 4. 存在则判断是否初始化
        User user = users.get(0);
        // 若没有初始化，返回初始化页面
        if (user.getInit() == 0) {
            // isInit为0，表示还未初始化，需要用户初始化信息
            res.put("isInit", 0);
            // 直接返回初始化页面
            return JsonResponse.success(res, "未初始化");
        } else {            // 5. 若初始化，返回角色标识符
            res.put("isInit", 1);
            // 0 为普通用户，1 为技术员
            res.put("userInfo", user);
            System.out.println(user);
            // 直接返回初始化页面
            return JsonResponse.success(res, "登录成功").addOtherData("orders",orderService.searchDoingOrder(user.getUserId()));
        }
    }

    @Override
    public JsonResponse init(Map<String, Object> params) {
        Map<String, Object> res = new HashMap<>();

        User user = new User();
        String username = (String) params.get("username");
        String qqNumber = (String) params.get("qqNumber");
        String phoneNumber = (String) params.get("phoneNumber");
        String email = (String) params.get("email");
        String avatarUrl = (String) params.get("avatarUrl");

        if (username != null) user.setUsername(username);
        if (qqNumber != null) user.setQqNumber(qqNumber);
        if (phoneNumber != null) user.setPhoneNumber(phoneNumber);
        if (email != null) user.setEmail(email);
        if (avatarUrl != null) user.setAvatarUrl(avatarUrl);
        user.setIsVip(0);
        user.setIsBan(0);
        user.setInit(1);
        user.setIsStaff(0);     // 默认为普通用户，技术员需要管理员分配
        user.setCreateTime(new Date());

        // 取出全局变量
        ConfExample confExample = new ConfExample();
        ConfExample.Criteria criteria = confExample.createCriteria();
        criteria.andGlobalFlagIsNotNull();
        List<Conf> confs = confMapper.selectByExample(confExample);

        // 设置初始化报修次数
        Conf conf = (confs == null ? null : confs.get(0));
        user.setRestRepairChance(conf.getLimitDay());

        // 插入用户信息
        int insert = userMapper.insert(user);

        // 重新取出user信息
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andPhoneNumberEqualTo(phoneNumber);

        List<User> users = userMapper.selectByExample(userExample);

        if (insert == 1) {
            res.put("isInit", 1);
            res.put("userInfo", users.get(0));
        } else {
            res.put("isInit", 0);
        }

        return JsonResponse.success(res, "初始化完成");
    }

    @Override
    public JsonResponse addVip(Long userId) {
        // 条件构造器
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        User user = new User();
        user.setIsVip(1);

        // 生成伪随机数作为vip码
        Long vipId = System.currentTimeMillis() + new Random().nextInt(100);
        user.setVipId(vipId);
        int isUpdate = userMapper.updateByExampleSelective(user, userExample);

        Map<String, Object> res = new HashMap<>();
        if (isUpdate == 1) {
            res.put("isVip", 1);
            res.put("vip_id", vipId);
        } else {
            res.put("isVip", 0);
        }

        return JsonResponse.success(res, "注册VIP");
    }

    @Override
    public JsonResponse updateVip(Map<String, Object> params) {
        Long user_id = Long.valueOf((String) params.get("user_id"));
        int isVip = Integer.valueOf((String) params.get("isVip"));
        Long vip_id = Long.valueOf((String) params.get("vip_id"));

        User user = new User();
        user.setUserId(user_id);
        user.setIsVip(isVip);
        user.setVipId(vip_id);
        int isUpdate = userMapper.updateByPrimaryKeySelective(user);

        Map<String, Object> res = new HashMap<>();
        if (isUpdate == 1) {
            res.put("isUpdate", 1);
        } else {
            res.put("isUpdate", 0);
        }

        return JsonResponse.success(res);
    }

    @Override
    public JsonResponse updateUser(Map<String, Object> params) {

        Long userId = Long.valueOf((String) params.get("user_id"));
        String username = (String) params.get("username");
        String qqNumber = (String) params.get("qqNumber");
        String phoneNumber = (String) params.get("phoneNumber");
        String email = (String) params.get("email");
        String avatarUrl = (String) params.get("avatarUrl");

        Integer isBan = null;
        if (params.get("isBan") != null) {
            isBan = Integer.valueOf((String) params.get("isBan"));
        }


        // 条件构造
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        // 得到原来的user信息
        User preUser = userMapper.selectByPrimaryKey(userId);

        // 更新信息
        if (username != null) preUser.setUsername(username);
        if (qqNumber != null) preUser.setQqNumber(qqNumber);
        if (phoneNumber != null) preUser.setPhoneNumber(phoneNumber);
        if (email != null) preUser.setEmail(email);
        if (avatarUrl != null) preUser.setAvatarUrl(avatarUrl);
        if (isBan != null) preUser.setIsBan(isBan);

        int isUpdate = userMapper.updateByPrimaryKeySelective(preUser);

        Map<String, Object> res = new HashMap<>();
        if (isUpdate == 1) {
            res.put("isUpdate", 1);
            res.put("userInfo", preUser);
        } else {
            res.put("isUpdate", 0);
        }

        return JsonResponse.success(res, "修改用户信息");
    }

    @Override
    public JsonResponse queryAll(int role){
        switch (role){
            case 0:
                return query0();
            case 1:
                return query1();
            case 2:
                return query2();
            default:
                return JsonResponse.failure("没有该角色");
        }
    }
    public JsonResponse query0(){
        UserExample ue = new UserExample();
        UserExample.Criteria criteria = ue.createCriteria();
        criteria.andIsStaffEqualTo(0);
        return JsonResponse.success(userMapper.selectByExample(ue));
    }
    public JsonResponse query1(){
        return JsonResponse.success(userMapper.selectStaff());
    }
    public JsonResponse query2(){
        AdminExample ae = new AdminExample();
        return JsonResponse.success(adminMapper.selectByExample(ae));
    }
}
