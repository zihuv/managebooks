package com.zihuv.managebooks.utils;

import com.zihuv.managebooks.constant.IdentityConst;
import com.zihuv.managebooks.enums.StatusCodeEnums;
import com.zihuv.managebooks.enums.UserAdminEnums;
import com.zihuv.managebooks.exception.BizException;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.util.List;
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
     * @param t       登录身份
     * @param session session
     * @return java.lang.Object
     */
    public static <T> Object checkLogin(Class<T> t, HttpSession session) {
        Object u = session.getAttribute(IdentityConst.LOGIN_INFO);
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
     * @param email 邮箱地址
     * @return boolean
     */
    public static boolean checkEmailError(String email) {
        String rule = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern p = Pattern.compile(rule);
        Matcher m = p.matcher(email);
        return !m.matches();
    }

    /**
     * 检查页码和显示条数的数据是否合法
     *
     * @param pageNum  页码
     * @param pageSize 显示条数
     */
    public static void checkPageNumAndSize(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null || pageNum < 0 || pageSize < 0) {
            throw new BizException(StatusCodeEnums.PARAM_ERROR);
        }
    }

    /**
     * 判断参数是否为空
     *
     * @param args 参数
     */
    public static void checkParamIsNull(Object... args) {
        for (Object arg : args) {
            if (arg == null) {
                throw new BizException(StatusCodeEnums.PARAM_IS_NULL);
            }
        }
    }

    /**
     * 检查路径是否合法
     *
     * @param pathName 路径
     */
    public static void checkPathName(String pathName) {
        File file = new File(pathName);
        if (!file.exists()) {
            throw new BizException(StatusCodeEnums.PATH_NAME_ERROR);
        }
    }
}