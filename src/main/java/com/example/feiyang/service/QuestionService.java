package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.entity.Question;

import java.util.List;

/**
 * @author 望舒
 * @date 2022/5/6 21:28
 */

public interface QuestionService {

    /**
     * 添加问题
     * @param question
     * @return
     */
    public JsonResponse addQuestion(Question question);

    /**
     * 问题分页查询接口
     * @param pageRequest 自定义，统一分页查询请求
     * @return
     */
    public PageResult getAllQuestions(PageRequest pageRequest);

    /**
     * 查询某一用户的所有问题
     * @param user_id
     * @return
     */
    public List<Question> getQuestionsByUserId(Long user_id);

    /**
     * 删除问题
     * @param question_id
     * @return
     */
    public JsonResponse deleteQuestion(Long question_id);
}