package com.zihuv.managebooks.service.impl;

import com.zihuv.managebooks.constant.IdentityConst;
import com.zihuv.managebooks.dao.UserDao;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.enums.StatusCodeEnums;
import com.zihuv.managebooks.enums.UserAdminEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.UserService;
import com.zihuv.managebooks.utils.CommonUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    HttpSession session;

    @Override
    public void insertUser(User user) {
        //检查user是否为空
        CommonUtils.checkParamIsNull(user);
        User u = userDao.getUserByUserName(user.getUserName());
        //若用户名已经存在，u != null，不允许注册
        if (u != null) {
            throw new BizException(UserAdminEnums.USER_IS_EXIST);
        }
        //判断邮箱格式是否合理
        if (CommonUtils.checkEmailError(user.getUserEmail())) {
            throw new BizException(UserAdminEnums.EMAIL_ERROR);
        }
        userDao.insertUser(user);
    }

    @Override
    public void login(User u) {
        User user = userDao.getUserByUserName(u.getUserName());
        //判断该用户名是否存在 和 密码是否匹配该用户
        if (user == null || !user.getUserPassword().equals(u.getUserPassword())) {
            throw new BizException(UserAdminEnums.USER_INFO_ERROR);
        }
        //将登录信息存进session
        session.setAttribute(IdentityConst.LOGIN_INFO,user);
    }

    @Override
    public void exit() {
        Object user = session.getAttribute(IdentityConst.LOGIN_INFO);
        //在session不存在用户，说明没有用户登录 user == null
        if (user == null) {
            throw new BizException(UserAdminEnums.USER_NOT_LOGIN);
        }
        session.removeAttribute(IdentityConst.LOGIN_INFO);
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