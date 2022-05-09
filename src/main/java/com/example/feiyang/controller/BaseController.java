package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.ex.InsertException;
import com.example.feiyang.service.ex.NullException;
import com.example.feiyang.service.ex.ServiceException;
import com.example.feiyang.service.ex.StaffDuplicationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层类的基类
 */
public class BaseController {
    /**
     * 操作成功的状态码
     */
    public static final boolean OK = true;

    //请求处理方法，这个方法的返回值就是需传递给前端的数据
    //自动将异常对象传递给此方法的参数列表上
    @ExceptionHandler(ServiceException.class)//用于统一处理抛出的异常
    public JsonResponse<Void> handleException(Throwable e) {
        JsonResponse<Void> result = new JsonResponse<>(e);
        if (e instanceof StaffDuplicationException) {
            result.setStatus(false);
            result.setMessage("该技术员已经存在");
        } else if (e instanceof InsertException) {
            result.setStatus(false);
            result.setMessage("注册时产生未知的异常");
        } else if (e instanceof NullException) {
            result.setStatus(false);
            result.setMessage("该用户id无效");
        }
        return result;
    }
}
