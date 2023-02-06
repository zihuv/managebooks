package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.annotation.OptLog;
import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.service.AdminService;
import com.zihuv.managebooks.service.UserService;
import com.zihuv.managebooks.utils.CommonUtils;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员管理
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
     * @param admin 管理员信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "管理员注册")
    @PostMapping("/admin/register")
    public Result<?> register(@RequestBody Admin admin) {
        adminService.register(admin);
        return Result.success();
    }

    /**
     * 管理员登录
     *
     * @param admin 管理员信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "管理员登录")
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
    @OptLog(value = "管理员退出登录")
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
    @OptLog(value = "查询所有管理员")
    @GetMapping("/admin")
    public Result<List<Admin>> listAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum,pageSize);
        List<Admin> admins = adminService.listAdmin(pageNum, pageSize);
        return Result.success(admins);
    }

    /**
     * 修改管理员信息
     *
     * @param admin 管理员信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "修改管理员信息")
    @PutMapping("/admin")
    public Result<?> updateUser(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return Result.success();
    }

    /**
     * 查询所有用户
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return com.zihuv.managebooks.vo.Result<java.util.List<com.zihuv.managebooks.entity.User>>
     */
    @OptLog(value = "查询所有用户")
    @GetMapping("/admin/user")
    public Result<List<User>> listUser(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum,pageSize);
        List<User> users = adminService.listUser(pageNum, pageSize);
        return Result.success(users);
    }

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return com.zihuv.managebooks.vo.Result<com.zihuv.managebooks.entity.User>
     */
    @OptLog(value = "根据id查询用户")
    @GetMapping("/admin/user/{id}")
    public Result<User> getUserById(@PathVariable Integer id) {
        User user = adminService.getUserById(id);
        return Result.success(user);
    }

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "添加用户")
    @PostMapping("/admin/user")
    public Result<?> insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return Result.success();
    }
}