package com.example.feiyang.service.ex;

/**
 * @author hyd
 * 用户名被占用的异常
 **/
public class UsernameDuplitedException extends ServiceException {
    public UsernameDuplitedException() {
        super();
    }

    public UsernameDuplitedException(String message) {
        super(message);
    }

    public UsernameDuplitedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplitedException(Throwable cause) {
        super(cause);
    }

    protected UsernameDuplitedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
