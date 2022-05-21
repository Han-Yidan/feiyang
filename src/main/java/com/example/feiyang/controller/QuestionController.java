package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.entity.Question;
import com.example.feiyang.service.impl.QuestionServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/6 21:29
 */

@Controller
@RequestMapping(value = "/question")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public JsonResponse addQuestion(@RequestBody Map<String, Object> params) {
        String question_content = (String) params.get("question_content");
        String question_image = (String) params.get("question_image");
        Long user_id = Long.valueOf((String) params.get("user_id"));

        Question question = new Question();
        question.setQuestionContent(question_content);
        question.setQuestionImage(question_image);
        question.setUserId(user_id);
        question.setCreateTime(new Date());

        JsonResponse res = questionService.addQuestion(question);

        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    public JsonResponse getAllQuestions(@RequestBody PageRequest pageQuery) {
        Map<String, Object> res = new HashMap<>();
        PageResult allQuestions = questionService.getAllQuestions(pageQuery);

        res.put("questions", allQuestions);
        return JsonResponse.success(res, "查询成功！");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getByUserId")
    @ResponseBody
    public JsonResponse getQuestionsByUserId(@PathParam("user_id") Long user_id) {
        Map<String, Object> res = new HashMap<>();
        List<Question> questions = questionService.getQuestionsByUserId(user_id);

        res.put("questions", questions);

        return JsonResponse.success(res, "查询成功！");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getById")
    @ResponseBody
    public JsonResponse getQuestionsById(@PathParam("question_id") Long question_id) {
        Map<String, Object> res = new HashMap<>();
        Question question = questionService.getQuestionsById(question_id);

        res.put("question", question);

        return JsonResponse.success(res, "查询成功！");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    @ResponseBody
    public JsonResponse deleteEvaluation(@PathParam("question_id") Long question_id) {
        JsonResponse res = questionService.deleteQuestion(question_id);

        return res;
    }
}
