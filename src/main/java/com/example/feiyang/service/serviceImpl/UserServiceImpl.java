package com.example.feiyang.service.serviceImpl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.common.utils.MessageUtils;
import com.example.feiyang.common.utils.ValidateCode;
import com.example.feiyang.dao.ConfMapper;
import com.example.feiyang.dao.UserMapper;
import com.example.feiyang.entity.Conf;
import com.example.feiyang.entity.ConfExample;
import com.example.feiyang.entity.User;
import com.example.feiyang.entity.UserExample;
import com.example.feiyang.service.UserService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            // 直接返回初始化页面
            return JsonResponse.success(res, "登录成功");
        }
    }

    @Override
    public boolean init(User user) {
        // 取出全局变量
        ConfExample confExample = new ConfExample();
        ConfExample.Criteria criteria = confExample.createCriteria();
        criteria.andGlobalFlagIsNotNull();
        List<Conf> confs = confMapper.selectByExample(confExample);

        Conf conf = (confs == null ? null : confs.get(0));
        user.setRestRepairChance(conf.getLimitDay());

        int insert = userMapper.insert(user);

        return insert == 1 ? true : false;
    }
}
