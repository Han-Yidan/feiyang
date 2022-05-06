package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Evaluation;
import com.example.feiyang.service.serviceImpl.EvaluationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/6 21:22
 */

@Controller
@RequestMapping(value = "/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationServiceImpl evaluationService;


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public JsonResponse addEvaluation(@RequestBody Map<String, Object> params) {
        Long order_id = Long.valueOf((String) params.get("order_id"));
        Long user_id = Long.valueOf((String) params.get("user_id"));
        Integer evaluation_score = Integer.valueOf((String) params.get("evaluation_score"));
        String evaluation_content = (String) params.get("evaluation_content");

        Evaluation evaluation = new Evaluation();
        evaluation.setOrderId(order_id);
        evaluation.setUserId(user_id);
        evaluation.setEvaluationScore(evaluation_score);
        evaluation.setEvaluationContent(evaluation_content);
        evaluation.setCreateTime(new Date());

        JsonResponse res = evaluationService.addEvaluation(evaluation);

        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    @ResponseBody
    public JsonResponse deleteEvaluation(@PathParam("evaluation_id") Long evaluation_id) {
        JsonResponse res = evaluationService.deleteEvaluation(evaluation_id);

        return res;
    }
}
