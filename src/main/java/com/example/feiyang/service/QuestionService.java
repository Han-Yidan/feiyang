package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.entity.PostAndQuestion;
import com.example.feiyang.entity.Question;

import javax.websocket.server.PathParam;
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
     * @return
     */
    public List<Question> getAllQuestions(Integer pageNum, Integer pageSize);

    /**
     * 查询某一用户的所有问题
     * @param user_id
     * @return
     */
    public List<Question> getQuestionsByUserId(Long user_id);

    /**
     * 根据问题ID查询问题信息
     * @param question_id
     * @return
     */
    public Question getQuestionsById(Long question_id);

    /**
     * 删除问题
     * @param question_id
     * @return
     */
    public JsonResponse deleteQuestion(Long question_id);

    /**
     * 搜索问题内容
     * @param content
     * @return
     */
    public List<PostAndQuestion> searchQuestion(String content, Integer pageNum, Integer pageSize);

    /**
     * 获取总问题数
     * @return
     */
    public Integer getTotalQuestion();
}
