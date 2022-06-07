package com.example.feiyang.service;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-06-07 13:48
 **/

public interface ConfService {
    //获取全局年份
    Integer getYear();
    int setting(Integer turn,Integer limit);
}
