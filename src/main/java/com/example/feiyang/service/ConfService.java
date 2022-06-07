package com.example.feiyang.service;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-06-07 13:48
 **/

public interface ConfService {
    //获取全局年份
    Integer getYear();
    //获取今日报修剩余量
    Integer getLimit();
    //设置全局信息
    int setting(Integer turn,Integer limit);
}
