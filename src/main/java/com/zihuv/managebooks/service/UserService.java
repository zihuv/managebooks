package com.zihuv.managebooks.service;

import com.zihuv.managebooks.entity.User;

import java.util.List;

/**
 * @author: zihuv
 * @date: 2023/1/23
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 用户登录
     *
     * @param user
     */
    void login(User user);

    /**
     * 退出登录
     */
    void exit();

    /**
     * 修改用户信息
     *
     * @param user
     */
    void updateUser(User user);
}