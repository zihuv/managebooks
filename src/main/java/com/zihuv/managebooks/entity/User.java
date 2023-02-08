package com.zihuv.managebooks.entity;

import lombok.Data;

/**
 * 用户
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Data
public class User {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户邮箱
     */
    private String userEmail;
}