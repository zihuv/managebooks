package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户管理
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Mapper
public interface UserDao {
    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return com.zihuv.managebooks.entity.User
     */
    User getUserByUserName(String userName);

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return int
     */
    int insertUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return int
     */
    int updateUser(User user);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return com.zihuv.managebooks.entity.User
     */
    User getUserById(Integer id);
}