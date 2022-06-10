package com.example.feiyang.service.ex;

/**
 * @author hyd
 * 技术员数据不存在的异常
 **/
public class StaffNotFoundException extends ServiceException{
    public StaffNotFoundException() {
        super();
    }

    public StaffNotFoundException(String message) {
        super(message);
    }

    public StaffNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StaffNotFoundException(Throwable cause) {
        super(cause);
    }

    protected StaffNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
