package com.zihuv.managebooks.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态码
 *
 * @author: zihuv
 * @date: 2023/1/21
 */
@Getter
@AllArgsConstructor
public enum StatusCodeEnums {
    /**
     * 操作成功
     */
    SUCCESS(20000, "操作成功"),

    /**
     * 操作失败
     */
    ERROR(40001, "操作失败"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(40404,"系统异常"),

    /**
     * 请求参数错误
     */
    PARAM_ERROR(50001, "请求参数错误");


    private Integer code;
    private String message;
}