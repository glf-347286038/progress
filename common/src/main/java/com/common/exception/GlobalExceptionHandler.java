package com.common.exception;

import com.common.web.domain.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常捕获
 *
 * @author Golf
 * @date 2022/10/21 17:24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public CommonResult<Object> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return CommonResult.error(500, e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public CommonResult<Object> serviceExceptionHandler(ServiceException e) {
        log.error(e.getMessage(), e);
        return CommonResult.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return CommonResult.error(null, e.getMessage());
    }
}
