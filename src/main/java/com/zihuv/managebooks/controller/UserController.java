package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.annotation.OptLog;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.service.UserService;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "用户注册")
    @PostMapping("/user/register")
    public Result<?> register(@RequestBody User user) {
        userService.insertUser(user);
        return Result.success();
    }

    /**
     * 用户登录
     *
     * @param user 用户信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "用户登录")
    @GetMapping("/user/login")
    public Result<?> login(@RequestBody User user) {
        userService.login(user);
        return Result.success();
    }

    /**
     * 用户退出登录
     *
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "用户退出登录")
    @GetMapping("/user/exit")
    public Result<?> exit() {
        userService.exit();
        return Result.success();
    }

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PutMapping("/user")
    @OptLog(value = "修改用户信息")
    public Result<?> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return Result.success();
    }
}