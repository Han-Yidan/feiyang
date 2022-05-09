package com.example.feiyang.common.utils;

import java.util.Random;

/**
 * @author 望舒
 * @date 2022/5/5 20:44
 */

public class ValidateCode {
    public static Integer generateValidateCode(int length) {
        Integer code = null;

        if (length == 4) {
            // 生成4位随机数
            code = new Random().nextInt(9999);
            if (code < 1000) {
                code += 1000;
            }
        } else if (length == 6) {
            code = new Random().nextInt(999999);
            if (code < 100000) {
                code += 100000;
            }
        } else {
            throw new RuntimeException("只能生成4位或6位数字验证码");
        }

        return code;
    }
}
