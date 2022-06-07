package com.example.feiyang.service.impl;

import com.example.feiyang.dao.ConfMapper;
import com.example.feiyang.entity.Conf;
import com.example.feiyang.entity.ConfExample;
import com.example.feiyang.service.ConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-06-07 13:49
 **/

@Service
public class ConfServiceImpl implements ConfService{
    @Autowired
    private ConfMapper confMapper;
    private static ConfExample ce = new ConfExample();
    private static Conf conf;
    @Autowired
    public void setConf(){
        conf = confMapper.selectByExample(ce).get(0);
    }

    @Override
    public Integer getYear() {
        return conf.getGlobalYear();
    }

    @Override
    public int setting(Integer turn,Integer limit) {
        if (turn != null) conf.setGlobalFlag(turn);
        if (limit != null) conf.setLimitDay(limit);
        return confMapper.updateByExample(conf,ce);
    }
}
