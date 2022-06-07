package com.example.feiyang.dao;

import com.example.feiyang.entity.Tips;
import com.example.feiyang.entity.TipsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TipsMapper {
    int countByExample(TipsExample example);

    int deleteByExample(TipsExample example);

    int insert(Tips record);

    int insertSelective(Tips record);

    //编辑公告
    int updateOnlyOne(Tips record);

    //查询公告
    List<Tips> selectOnlyOne();

    List<Tips> selectByExampleWithBLOBs(TipsExample example);

    List<Tips> selectByExample(TipsExample example);

    int updateByExampleSelective(@Param("record") Tips record, @Param("example") TipsExample example);

    int updateByExampleWithBLOBs(@Param("record") Tips record, @Param("example") TipsExample example);

    int updateByExample(@Param("record") Tips record, @Param("example") TipsExample example);
}