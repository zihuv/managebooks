package com.zihuv.managebooks.utils;

import com.zihuv.managebooks.enums.UserAdminEnums;
import com.zihuv.managebooks.exception.BizException;
import jakarta.servlet.http.HttpSession;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公共工具类
 *
 * @author: zihuv
 * @date: 2023/2/4
 */
public class CommonUtils {
    /**
     * 判断登录状态和身份，并返回登录身份对象
     *
     * @param t
     * @param session
     * @return java.lang.Object
     */
    public static <T> Object checkLogin(Class<T> t, HttpSession session) {
        Object u = session.getAttribute("user");
        //u==null 说明用户没登录
        if (u == null) {
            throw new BizException(UserAdminEnums.USER_NOT_LOGIN);
        }
        //判断当前登录的身份和需求的身份是否一致
        if (!u.getClass().equals(t)) {
            throw new BizException(UserAdminEnums.IDENTITY_ERROR);
        }
        return u;
    }

    /**
     * 判断邮箱格式是否合理 true代表不合理 false代表合理
     *
     * @param email
     * @return boolean
     */
    public static boolean checkEmailError(String email) {
        String rule = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern p = Pattern.compile(rule);
        Matcher m = p.matcher(email);
        return !m.matches();
    }
}