package com.zihuv.managebooks.service;

import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.User;

import java.util.List;

public interface AdminService {
    /**
     * 管理员注册
     *
     * @param admin
     */
    void register(Admin admin);

    /**
     * 管理员登录
     *
     * @param admin
     */
    void login(Admin admin);

    /**
     * 退出登录
     */
    void exit();

    /**
     * 查询所有管理员
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return java.util.List<com.zihuv.managebooks.entity.Admin>
     */
    List<Admin> listAdmin(Integer pageNum, Integer pageSize);

    /**
     * 修改管理员信息
     *
     * @param admin
     */
    void updateAdmin(Admin admin);

    /**
     * 查询所有用户
     *
     * @return java.util.List<com.zihuv.managebooks.entity.User>
     */
    List<User> listUser(Integer pageNum, Integer pageSize);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return com.zihuv.managebooks.entity.User
     */
    User getUserById(Integer id);
}
