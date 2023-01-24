package com.zihuv.managebooks.service.impl;

import com.zihuv.managebooks.dao.UserDao;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.enums.UserAdminEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zihuv
 * @date: 2023/1/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    HttpServletRequest request;

    @Override
    public void insertUser(User user) {
        User u = userDao.getUserByUserName(user.getUserName());
        //若用户名已经存在，u != null，不允许注册
        if (u != null) {
            throw new BizException(UserAdminEnums.USER_IS_EXIST);
        }
        userDao.insertUser(user);
    }

    @Override
    public void login(User user) {
        User u = userDao.getUserByUserName(user.getUserName());
        //判断该用户名是否存在 和 密码是否匹配该用户
        if (u == null || !u.getUserPassword().equals(user.getUserPassword())) {
            throw new BizException(UserAdminEnums.USER_INFO_ERROR);
        }
        HttpSession session = request.getSession();
        //将登录信息存进session
        session.setAttribute("user",user);
    }

    @Override
    public void exit() {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        //在session不存在用户，说明没有用户登录 user == null
        if (user == null) {
            throw new BizException(UserAdminEnums.USER_NOT_LOGIN);
        }
        session.removeAttribute("user");
    }

    @Override
    public void updateUser(User user) {
        User u = userDao.getUserById(user.getId());
        //判断该用户名是否已经存在，存在才能修改
        if (u == null) {
            throw new BizException(UserAdminEnums.USER_NOT_EXIST);
        }
        userDao.updateUser(user);
    }
}