package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理员管理
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Mapper
public interface AdminDao {
    /**
     * 根据管理员名查询管理员
     *
     * @param adminName 管理员名称
     * @return com.zihuv.managebooks.entity.Admin
     */
    Admin getAdminByAdminName(String adminName);

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     * @return int
     */
    int insertAdmin(Admin admin);

    /**
     * 查询所有管理员
     *
     * @return java.util.List<com.zihuv.managebooks.entity.Admin>
     */
    List<Admin> listAdmin();

    /**
     * 修改管理员信息
     *
     * @param admin 管理员信息
     * @return int
     */
    int updateAdmin(Admin admin);

    /**
     * 根据id查询管理员
     *
     * @param id 管理员id
     * @return com.zihuv.managebooks.entity.Admin
     */
    Admin getAdminById(Integer id);

    /**
     * 查询所有用户
     *
     * @return java.util.List<com.zihuv.managebooks.entity.User>
     */
    List<User> listUser();

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return com.zihuv.managebooks.entity.User
     */
    User getUserById(Integer id);

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return int
     */
    int insertUser(User user);
}