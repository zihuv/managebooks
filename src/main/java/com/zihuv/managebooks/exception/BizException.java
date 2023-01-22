package com.zihuv.managebooks.exception;


import com.zihuv.managebooks.enums.BookStatusEnums;
import com.zihuv.managebooks.enums.StatusCodeEnums;
import lombok.Getter;

/**
 * 业务异常
 *
 * @author: zihuv
 * @date: 2023/1/22
 */

@Getter
public class BizException extends RuntimeException{
    /**
     * 返回码
     */
    private final Integer code;

    /**
     * 返回信息
     */
    private final String message;

    public BizException(StatusCodeEnums statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public BizException(BookStatusEnums statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public BizException(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}