package com.zihuv.managebooks.service.impl;

import com.github.pagehelper.PageHelper;
import com.zihuv.managebooks.constant.IdentityConst;
import com.zihuv.managebooks.dao.AdminDao;
import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.enums.UserAdminEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.AdminService;
import com.zihuv.managebooks.utils.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员管理
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    HttpServletRequest request;

    @Override
    public void register(Admin admin) {
        Admin a = adminDao.getAdminByAdminName(admin.getAdminName());
        //若管理员已经存在，a != null，不允许注册
        if (a != null) {
            throw new BizException(UserAdminEnums.ADMIN_IS_EXIST);
        }
        //判断邮箱格式是否合理
        if (CommonUtils.checkEmailError(admin.getAdminEmail())) {
            throw new BizException(UserAdminEnums.EMAIL_ERROR);
        }
        adminDao.insertAdmin(admin);
    }

    @Override
    public void login(Admin admin) {
        Admin a = adminDao.getAdminByAdminName(admin.getAdminName());
        //判断该管理员名是否存在 和 密码是否匹配该管理员
        if (a == null || !a.getAdminPassword().equals(admin.getAdminPassword())) {
            throw new BizException(UserAdminEnums.ADMIN_INFO_ERROR);
        }
        HttpSession session = request.getSession();
        //将登录信息存进session
        session.setAttribute(IdentityConst.LOGIN_INFO,admin);
    }

    @Override
    public void exit() {
        HttpSession session = request.getSession();
        Object admin = session.getAttribute(IdentityConst.LOGIN_INFO);
        //在session不存在管理员，说明没有管理员登录 admin == null
        if (admin == null) {
            throw new BizException(UserAdminEnums.ADMIN_NOT_LOGIN);
        }
        session.removeAttribute(IdentityConst.LOGIN_INFO);
    }

    @Override
    public List<Admin> listAdmin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return adminDao.listAdmin();
    }

    @Override
    public void updateAdmin(Admin admin) {
        Admin a = adminDao.getAdminById(admin.getId());
        //判断该管理员名是否已经存在，存在才能修改
        if (a == null) {
            throw new BizException(UserAdminEnums.ADMIN_NOT_EXIST);
        }
        adminDao.updateAdmin(admin);
    }

    @Override
    public List<User> listUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return adminDao.listUser();
    }

    @Override
    public User getUserById(Integer id) {
        return adminDao.getUserById(id);
    }
}