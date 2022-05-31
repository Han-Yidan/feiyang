package com.example.feiyang.dao;

import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.PostAndQuestion;
import com.example.feiyang.entity.Question;
import com.example.feiyang.entity.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionMapper {
    int countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Long questionId);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Long questionId);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    /**
     * 分页查询用户
     * @return
     */
    List<Question> selectPage();

    List<Question> queryQuestionByKey(@Param("key") String key);

    List<PostAndQuestion> searchQuestion(@Param("content") String content, @Param("postUsername") String postUsername,
                                         @Param("questionUsername") String questionUsername,
                                         @Param("visit_count") Integer visit_count, @Param("status") Integer status);

}