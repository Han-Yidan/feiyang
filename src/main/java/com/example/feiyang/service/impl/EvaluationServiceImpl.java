package com.example.feiyang.service.serviceImpl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.dao.EvaluationMapper;
import com.example.feiyang.entity.Evaluation;
import com.example.feiyang.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/6 20:33
 */

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    EvaluationMapper evaluationMapper;

    @Override
    public JsonResponse addEvaluation(Evaluation evaluation) {
        int isInsert = evaluationMapper.insert(evaluation);

        Map<String, Object> res = new HashMap<>();

        if (isInsert == 1) {
            res.put("isAdd", 1);
            res.put("evaluationInfo", evaluation);
        } else {
            res.put("isAdd", 0);
        }

        return JsonResponse.success(res, "添加评论");
    }

    @Override
    public JsonResponse deleteEvaluation(Long evaluation_id) {
        int isDeleted = evaluationMapper.deleteByPrimaryKey(evaluation_id);

        Map<String, Object> res = new HashMap<>();
        if (isDeleted == 1) {
            res.put("isDeleted", 1);
            return JsonResponse.success(res, "删除成功！");
        }

        res.put("isDeleted", 0);
        return JsonResponse.success(res, "删除失败！");
    }
}
