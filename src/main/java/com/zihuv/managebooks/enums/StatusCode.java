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
public enum StatusCode {
    /**
     * 成功
     */
    SUCCESS(20000, "操作成功"),

    /**
     * 失败
     */
    ERROR(20001, "操作失败"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(40404,"系统异常"),

    /**
     * 参数校验失败
     */
    VALID_ERROR(50001, "参数格式不正确"),

    /**
     * 用户名已存在
     */
    USERNAME_EXIST(51001, "用户名已存在"),

    /**
     * 用户名或密码不存在
     */
    USER_NOT_EXIST(51002, "用户名或密码不存在"),

    /**
     * 不存在该id
     */
    ID_NOT_EXIST(51003,"不存在该id"),

    /**
     * 密码不能为空
     */
    PASSWORD_IS_NULL(51004,"密码不能为空");

    private Integer code;
    private String message;
}