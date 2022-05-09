package com.example.feiyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan({"com.example.feiyang.dao"})
public class FeiyangApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeiyangApplication.class, args);
    }

}
