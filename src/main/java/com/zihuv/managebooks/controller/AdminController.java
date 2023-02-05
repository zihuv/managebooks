package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.service.AdminService;
import com.zihuv.managebooks.service.UserService;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员Controller
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    /**
     * 管理员注册
     *
     * @param admin
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PostMapping("/admin/register")
    public Result<?> register(@RequestBody Admin admin) {
        adminService.register(admin);
        return Result.success();
    }

    /**
     * 管理员登录
     *
     * @param admin
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @GetMapping("/admin/login")
    public Result<?> login(@RequestBody Admin admin) {
        adminService.login(admin);
        return Result.success();
    }

    /**
     * 管理员退出登录
     *
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @GetMapping("/admin/exit")
    public Result<?> exit() {
        adminService.exit();
        return Result.success();
    }

    /**
     * 查询所有管理员
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.entity.Admin>>
     */
    @GetMapping("/admin")
    public Result<List<Admin>> listAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<Admin> admins = adminService.listAdmin(pageNum, pageSize);
        return Result.success(admins);
    }

    /**
     * 修改管理员信息
     *
     * @param admin
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PutMapping("/admin")
    public Result<?> updateUser(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return Result.success();
    }

    /**
     * 查询所有用户
     *
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.entity.User>>
     */
    @GetMapping("/admin/user")
    public Result<List<User>> listUser(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<User> users = adminService.listUser(pageNum, pageSize);
        return Result.success(users);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return com.zihuv.managebooks.vo.Result<com.zihuv.managebooks.entity.User>
     */
    @GetMapping("/admin/user/{id}")
    public Result<User> getUserById(@PathVariable Integer id) {
        User user = adminService.getUserById(id);
        return Result.success(user);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PostMapping("/admin/user")
    public Result<?> insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return Result.success();
    }
}