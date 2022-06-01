package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.entity.PostAndQuestion;
import com.example.feiyang.entity.Question;
import com.example.feiyang.service.impl.QuestionServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public JsonResponse getAllQuestions(@PathParam("pageNum") Integer pageNum, @PathParam("pageSize") Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        List<Question> allQuestions = questionService.getAllQuestions(pageNum, pageSize);

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

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public JsonResponse searchQuestion(@PathParam("content") String content, @PathParam("postUsername") String postUsername,
                                       @PathParam("questionUsername") String questionUsername, @PathParam("visitCount") Integer visitCount,
                                       @PathParam("status") Integer status, @PathParam("pageNum") Integer pageNum, @PathParam("pageSize") Integer pageSize) {

        Map<String, Object> res = questionService.searchQuestion(content, postUsername, questionUsername, visitCount, status, pageNum, pageSize);

        return JsonResponse.success(res, "搜索成功！");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryByKey")
    @ResponseBody
    public JsonResponse queryQuestion(@PathParam("key") String key) {
        List<Question> questions = questionService.queryQuestionByKey(key);
        Map<String, Object> res = new HashMap<>();

        res.put("questions", questions);

        return JsonResponse.success(res, "查询成功！");
    }
}
