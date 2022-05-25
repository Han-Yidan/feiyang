package com.example.feiyang.common.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author 望舒
 * @date 2022/5/24 20:33
 */

@Configuration
public class ValueConfig {
    @Value("${server.port}")
    private Integer serverPort;
}
