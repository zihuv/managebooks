package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.service.UserService;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理Controller
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
     * @param user
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PostMapping("/user/register")
    public Result<?> register(@RequestBody User user) {
        userService.insertUser(user);
        return Result.success();
    }

    /**
     * 用户登录
     *
     * @param user
     * @return com.zihuv.managebooks.vo.Result<?>
     */
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
    @GetMapping("/user/exit")
    public Result<?> exit() {
        userService.exit();
        return Result.success();
    }

    /**
     * 修改用户信息
     *
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PutMapping("/user")
    public Result<?> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return Result.success();
    }
}