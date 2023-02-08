package com.zihuv.managebooks.entity;

import lombok.Data;

/**
 * 管理员
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Data
public class Admin {
    /**
     * 管理员id
     */
    private Integer id;

    /**
     * 管理员名
     */
    private String adminName;

    /**
     * 管理员密码
     */
    private String adminPassword;

    /**
     * 管理员邮箱
     */
    private String adminEmail;
}