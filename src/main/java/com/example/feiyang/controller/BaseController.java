package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.service.ex.*;
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
            result.setMessage("插入数据时产生未知的异常");
        } else if (e instanceof NullException) {
            result.setStatus(false);
            result.setMessage("空值异常");
        } else if (e instanceof StaffNotFoundException) {
            result.setStatus(false);
            result.setMessage("不存在这个技术员");
        } else if (e instanceof DeleteException) {
            result.setStatus(false);
            result.setMessage("删除数据时产生未知的异常");
        } else if (e instanceof PostNotFoundException) {
            result.setStatus(false);
            result.setMessage("不存在这个帖子");
        } else if (e instanceof UpdateException) {
            result.setStatus(false);
            result.setMessage("修改数据时产生未知的异常");
        }
        return result;
    }
}
