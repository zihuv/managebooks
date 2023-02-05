package com.zihuv.managebooks.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户和管理员枚举类
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Getter
@AllArgsConstructor
public enum UserAdminEnums {
    USER_IS_EXIST(10000,"该用户已经存在"),
    USER_NOT_EXIST(10001,"该用户不存在"),
    USER_NOT_LOGIN(11000,"当前没有用户登录"),
    USER_INFO_ERROR(12000,"用户名或密码不存在"),

    ADMIN_IS_EXIST(20000,"该管理员已经存在"),
    ADMIN_NOT_EXIST(20001,"该管理员不存在"),
    ADMIN_NOT_LOGIN(21000,"当前没有管理员登录"),
    ADMIN_INFO_ERROR(22000,"管理员名或密码不存在"),

    /**
     * 登录身份错误，切换用户身份后再试
     */
    IDENTITY_ERROR(30000,"登录身份错误，切换用户身份后再试"),

    EMAIL_ERROR(31000,"邮箱格式错误");

    private Integer code;
    private String message;
}
