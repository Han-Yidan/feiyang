package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.ConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-06-07 13:47
 **/

@RestController
@RequestMapping("/conf")
public class ConfController {
    @Autowired
    private ConfService confService;
    /**
     * 获取全局年份
     * @return
     */
    @RequestMapping("/year")
    public JsonResponse getYear(){
        return JsonResponse.success(confService.getYear());
    }

    @RequestMapping("/getLimit")
    public JsonResponse getLimit(){
        return JsonResponse.success(confService.getLimit());
    }
    /**
     * 设置系统开关
     * @param turn
     * @return
     */
    @RequestMapping("/turn")
    public JsonResponse turn(Integer turn){
        int result = confService.setting(turn,null);
        if(result == 1) return JsonResponse.success("系统开关状态改变成功");
        return JsonResponse.failure("系统开关状态改变失败");
    }

    /**
     * 设置每日报修数量
     * @param limit
     * @return
     */
    @RequestMapping("/setLimit")
    public JsonResponse setLimit(Integer limit){
        int result = confService.setting(null,limit);
        if(result == 1) return JsonResponse.success("修改成功");
        return JsonResponse.failure("修改失败");
    }
}
