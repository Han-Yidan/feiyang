package com.example.feiyang.dao;

import com.example.feiyang.entity.Conf;
import com.example.feiyang.entity.ConfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfMapper {
    int countByExample(ConfExample example);

    int deleteByExample(ConfExample example);

    int insert(Conf record);

    int insertSelective(Conf record);

    List<Conf> selectByExampleWithBLOBs(ConfExample example);

    List<Conf> selectByExample(ConfExample example);

    int updateByExampleSelective(@Param("record") Conf record, @Param("example") ConfExample example);

    int updateByExampleWithBLOBs(@Param("record") Conf record, @Param("example") ConfExample example);

    int updateByExample(@Param("record") Conf record, @Param("example") ConfExample example);
}