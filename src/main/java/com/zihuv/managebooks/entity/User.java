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
    private Integer id;
    private String userName;
    private String userPassword;
    private String userEmail;
}