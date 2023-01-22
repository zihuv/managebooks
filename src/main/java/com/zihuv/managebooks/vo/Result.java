package com.zihuv.managebooks.vo;

import com.zihuv.managebooks.enums.StatusCode;
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
        return makeResult(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> success(T data) {
        return makeResult(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> error() {
        return makeResult(StatusCode.ERROR.getCode(), StatusCode.ERROR.getMessage(), null);
    }

    public static <T> Result<T> error(T data) {
        return makeResult(StatusCode.ERROR.getCode(), StatusCode.ERROR.getMessage(), data);
    }

    public static <T> Result<T> error(StatusCode statusCode) {
        return makeResult(statusCode.getCode(), statusCode.getMessage(), null);
    }

    public static <T> Result<T> error(StatusCode statusCode, T data) {
        return makeResult(statusCode.getCode(), statusCode.getMessage(), data);
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