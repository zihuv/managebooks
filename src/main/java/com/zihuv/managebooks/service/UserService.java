package com.zihuv.managebooks.service;

import com.zihuv.managebooks.entity.User;

public interface UserService {
    /**
     * 用户注册
     *
     * @param user 用户信息
     */
    void insertUser(User user);

    /**
     * 用户登录
     *
     * @param user 用户信息
     */
    void login(User user);

    /**
     * 退出登录
     */
    void exit();

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     */
    void updateUser(User user);
}