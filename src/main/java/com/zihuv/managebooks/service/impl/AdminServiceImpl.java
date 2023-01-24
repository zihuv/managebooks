package com.zihuv.managebooks.service.impl;

import com.zihuv.managebooks.dao.AdminDao;
import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.enums.UserAdminEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.AdminService;
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
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    HttpServletRequest request;

    @Override
    public void register(Admin admin) {
        Admin a = adminDao.getAdminByAdminName(admin.getAdminName());
        //若管理员名已经存在，u != null，不允许注册
        if (a != null) {
            throw new BizException(UserAdminEnums.ADMIN_IS_EXIST);
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
        session.setAttribute("admin",admin);
    }

    @Override
    public void exit() {
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");
        //在session不存在管理员，说明没有管理员登录 admin == null
        if (admin == null) {
            throw new BizException(UserAdminEnums.ADMIN_NOT_LOGIN);
        }
        session.removeAttribute("admin");
    }

    @Override
    public List<Admin> listAdmin() {
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
    public List<User> listUser() {
        return adminDao.listUser();
    }

    @Override
    public User getUserById(Integer id) {
        return adminDao.getUserById(id);
    }
}