package com.zihuv.managebooks.handler;


import com.zihuv.managebooks.enums.StatusCodeEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author: zihuv
 * @date: 2023/1/22
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理业务异常
     */
    @ExceptionHandler(BizException.class)
    public Result<?> doBizException(BizException e) {
        return Result.error(e);
    }

    /**
     * 处理系统异常
     */
    @ExceptionHandler(Exception.class)
    public Result<?> doException(Exception e) {
        e.printStackTrace();
        return Result.error(StatusCodeEnums.SYSTEM_ERROR);
    }
}