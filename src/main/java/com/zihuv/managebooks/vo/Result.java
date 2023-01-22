package com.zihuv.managebooks.vo;


import com.zihuv.managebooks.enums.StatusCodeEnums;
import com.zihuv.managebooks.exception.BizException;
import lombok.Data;

/**
 * 统一返回结果给前端
 *
 * @author: zihuv
 * @date: 2023/1/21
 */
@Data
public class Result<T> {
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public static <T> Result<T> success() {
        return makeResult(StatusCodeEnums.SUCCESS.getCode(), StatusCodeEnums.SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> success(T data) {
        return makeResult(StatusCodeEnums.SUCCESS.getCode(), StatusCodeEnums.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> error() {
        return makeResult(StatusCodeEnums.ERROR.getCode(), StatusCodeEnums.ERROR.getMessage(), null);
    }

    public static <T> Result<T> error(T data) {
        return makeResult(StatusCodeEnums.ERROR.getCode(), StatusCodeEnums.ERROR.getMessage(), data);
    }

    public static <T> Result<T> error(StatusCodeEnums statusCode) {
        return makeResult(statusCode.getCode(), statusCode.getMessage(), null);
    }

    public static <T> Result<T> error(StatusCodeEnums statusCode, T data) {
        return makeResult(statusCode.getCode(), statusCode.getMessage(), data);
    }

    public static <T> Result<T> error(BizException e) {
        return makeResult(e.getCode(),e.getMessage(),null);
    }

    /**
     * 生成Result对象
     *
     * @param code
     * @param message
     * @param data
     * @return com.zihuv.managebooks.vo.Result<T>
     */
    private static <T> Result<T> makeResult(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}