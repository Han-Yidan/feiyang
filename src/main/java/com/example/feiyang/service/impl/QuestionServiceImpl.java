package com.example.feiyang.service.impl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.dao.QuestionMapper;
import com.example.feiyang.entity.*;
import com.example.feiyang.service.QuestionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/6 21:28
 */

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getAllQuestions(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Question> allQuestions = questionMapper.selectPage();

        return allQuestions;
    }

    @Override
    public List<Question> getQuestionsByUserId(Long user_id) {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andUserIdEqualTo(user_id);

        List<Question> questions = questionMapper.selectByExample(questionExample);

        return questions;
    }

    @Override
    public Question getQuestionsById(Long question_id) {
        Question question = questionMapper.selectByPrimaryKey(question_id);
        return question;
    }

    @Override
    public JsonResponse addQuestion(Question question) {
        int isInsert = questionMapper.insert(question);
        Map<String, Object> res = new HashMap<>();

        if (isInsert == 1) {
            res.put("isAdd", 1);
            res.put("questionInfo", question);

            return JsonResponse.success(res, "添加成功！");
        }
        res.put("isAdd", 0);

        return JsonResponse.success(res, "添加失败！");
    }

    @Override
    public JsonResponse deleteQuestion(Long question_id) {
        int isDeleted = questionMapper.deleteByPrimaryKey(question_id);

        Map<String, Object> res = new HashMap<>();
        if (isDeleted == 1) {
            res.put("isDeleted", 1);
            return JsonResponse.success(res, "删除成功！");
        }

        res.put("isDeleted", 0);
        return JsonResponse.success(res, "删除失败！");
    }



    @Override
    public Map<String, Object> searchQuestion(String content, Integer pageNum, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();

        // 获取总数
        List<PostAndQuestion> postAndQuestions = questionMapper.searchQuestion(content);
        res.put("totalCount", postAndQuestions.size());

        // 获取分页后的结果
        postAndQuestions = questionMapper.searchQuestion(content);
        res.put("posts", postAndQuestions);

        return res;
    }

    @Override
    public Integer getTotalQuestion() {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andQuestionIdIsNotNull();

        int countQuestion = questionMapper.countByExample(questionExample);
        return countQuestion;
    }
}
