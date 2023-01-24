package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: zihuv
 * @date: 2023/1/23
 */
@Mapper
public interface UserDao {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return com.zihuv.managebooks.entity.User
     */
    User getUserByUserName(String userName);

    /**
     * 添加用户
     *
     * @param user
     * @return int
     */
    int insertUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return int
     */
    int updateUser(User user);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return com.zihuv.managebooks.entity.User
     */
    User getUserById(Integer id);
}