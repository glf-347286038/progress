package com.common.exception;

/**
 * 业务异常
 *
 * @author Golf
 * @date 2022/10/21 16:53
 */
public class ServiceException extends RuntimeException {
    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String message;

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message) {
        this.code = 500;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
