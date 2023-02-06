package com.zihuv.managebooks.constant;

import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.User;

/**
 * 登录身份常量
 *
 * @author: zihuv
 * @date: 2023/2/4
 */
public class IdentityConst {
    /**
     * 管理员字节码
     */
    public static final Class<Admin> ADMIN = com.zihuv.managebooks.entity.Admin.class;

    /**
     * 普通用户字节码
     */
    public static final Class<User> USER = com.zihuv.managebooks.entity.User.class;

    /**
     * 登录信息
     */
    public static final String LOGIN_INFO = "loginInfo";
}