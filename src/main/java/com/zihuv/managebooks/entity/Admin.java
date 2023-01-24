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
    private Integer id;
    private String adminName;
    private String adminPassword;
    private String adminEmail;
}