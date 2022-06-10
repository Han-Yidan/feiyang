package com.example.feiyang.service.ex;

/**
 * @author hyd
 * 技术员重复插入的异常
 */
public class StaffDuplicationException extends ServiceException {
    public StaffDuplicationException() {
        super();
    }

    public StaffDuplicationException(String message) {
        super(message);
    }

    public StaffDuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public StaffDuplicationException(Throwable cause) {
        super(cause);
    }

    protected StaffDuplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
