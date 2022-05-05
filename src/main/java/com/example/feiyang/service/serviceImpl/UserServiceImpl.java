package com.example.feiyang.service.serviceImpl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.common.utils.MessageUtils;
import com.example.feiyang.common.utils.ValidateCode;
import com.example.feiyang.dao.UserMapper;
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

    public JsonResponse login(String phoneNumber) {
        Map<String, Integer> result = new HashMap<>();

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

        // 2. 判断user表中是否存在该手机号
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneNumberEqualTo(phoneNumber);
        List<User> users = userMapper.selectByExample(userExample);

        System.out.println(users);

        // 3. 不存在则添加
        if (users == null) {
            User user = new User();
            user.setPhoneNumber(phoneNumber);
            userMapper.insert(user);

            result.put("isInit", 0);
            // 直接返回初始化
            return JsonResponse.success(result, "未初始化");
        }
        // 4. 存在则判断是否初始化

        // 5. 若初始化，返回角色标识符

        // 6. 若没有初始化，返回初始化页面
        return new JsonResponse();
    }
}
