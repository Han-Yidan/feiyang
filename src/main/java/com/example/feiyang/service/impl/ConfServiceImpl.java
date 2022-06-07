package com.example.feiyang.service.impl;

import com.example.feiyang.dao.ConfMapper;
import com.example.feiyang.dao.TipsMapper;
import com.example.feiyang.entity.Conf;
import com.example.feiyang.entity.ConfExample;
import com.example.feiyang.entity.Tips;
import com.example.feiyang.service.ConfService;
import com.example.feiyang.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-06-07 13:49
 **/

@Service
public class ConfServiceImpl implements ConfService {
    @Autowired
    private ConfMapper confMapper;
    private TipsMapper tipsMapper;
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
    public Integer getLimit() {
        return conf.getLimitDay();
    }

    @Override
    public int setting(Integer turn, Integer limit) {
        if (turn != null) conf.setGlobalFlag(turn);
        if (limit != null) conf.setLimitDay(limit);
        return confMapper.updateByExample(conf, ce);
    }

    @Override
    public Boolean updateGlobalTips(String title, String tips, Integer isPop) {
        Tips tips1 = new Tips();
        tips1.setTips(tips);
        tips1.setTitle(title);
        tips1.setIsPop(isPop);
        Integer integer = tipsMapper.updateOnlyOne(tips1);
        if (integer != 1) {
            throw new UpdateException("更新公告过程中出现未知异常");
        }
        return true;
    }

    @Override
    public List<Tips> selectTips() {
        List<Tips> tips1 = tipsMapper.selectOnlyOne();
        return tips1;
    }

}
