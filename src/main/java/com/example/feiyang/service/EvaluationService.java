package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Evaluation;

/**
 * @author 望舒
 * @date 2022/5/6 20:33
 */

public interface EvaluationService {
    /**
     * 添加评论
     * @param evaluation
     * @return
     */
    public JsonResponse addEvaluation(Evaluation evaluation);

    /**
     * 删除评论
     * @param evaluation_id
     * @return
     */
    public JsonResponse deleteEvaluation(Long evaluation_id);
}
