package com.example.feiyang.dao;

import com.example.feiyang.entity.Evaluation;
import com.example.feiyang.entity.EvaluationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluationMapper {
    int countByExample(EvaluationExample example);

    int deleteByExample(EvaluationExample example);

    int deleteByPrimaryKey(Integer evaluationId);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    List<Evaluation> selectByExample(EvaluationExample example);

    Evaluation selectByPrimaryKey(Integer evaluationId);

    int updateByExampleSelective(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByExample(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}