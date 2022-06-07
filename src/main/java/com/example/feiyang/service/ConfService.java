package com.example.feiyang.service;

import com.example.feiyang.entity.Tips;

import java.util.List;

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
    int setting(Integer turn, Integer limit);

    //编辑公告
    Boolean updateGlobalTips(String title, String tips, Integer isPop);

    //查询唯一的一条公告
    List<Tips> selectTips();
}
