package com.yxc.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxc.system.model.R;
import com.yxc.system.model.User;
import com.yxc.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 *  用户表前端控制器
 * </p>
 *
 * @author 杨旭晨
 * @since 2020-07-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("list")
    public R list(@RequestBody User queryUser, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.list(queryUser);
        PageInfo pageInfo = new PageInfo(userList);
        return R.ok().put("data", pageInfo);
    }

    @PostMapping("update")
    public R update(@RequestBody User updateUser) {
        return userService.updateById(updateUser) ? R.ok() : R.error();
    }

    @PostMapping("add")
    public R add(@RequestBody User addUser) {
        addUser.setConfirmed(0);
        addUser.setPasswordHash("123456");
        return userService.save(addUser) ? R.ok() : R.error();
    }

    @PostMapping("delete/{id}")
    public R delete(@PathVariable Integer id) {
        return userService.removeById(id) ? R.ok() : R.error();
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return R.ok().put("data", userService.getById(id));
    }

    @PostMapping("checkUsername/{username}")
    public R chechUsername(@PathVariable String username) {
        return userService.checkUsername(username) ? R.ok() : R.error();
    }

    @PostMapping("checkStuNum/{stuNum}")
    public R chechStuNum(@PathVariable String stuNum) {
        return userService.checkStuNum(stuNum) ? R.ok() : R.error();
    }
}

