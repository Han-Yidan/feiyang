package com.example.feiyang;

import com.example.feiyang.common.utils.MessageUtils;
import com.example.feiyang.common.utils.ValidateCode;
import com.example.feiyang.dao.UserMapper;
import com.example.feiyang.entity.User;
import com.example.feiyang.entity.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 望舒
 * @date 2022/5/5 20:52
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUtils {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testSendMessage() {
        MessageUtils messageUtils = new MessageUtils();
        Integer vode = ValidateCode.generateValidateCode(6);
        messageUtils.sendMessage("13408177059", String.valueOf(vode));
    }

    @Test
    public void testMysql() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneNumberEqualTo("13408177059");
        List<User> users = userMapper.selectByExample(userExample);

        System.out.println(users == null);
    }
}
