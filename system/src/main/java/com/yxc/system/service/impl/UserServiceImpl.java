package com.yxc.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxc.system.model.User;
import com.yxc.system.mapper.UserMapper;
import com.yxc.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  用户表服务实现类
 * </p>
 *
 * @author 杨旭晨
 * @since 2020-07-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list(User queryUser) {
        return userMapper.list(queryUser);
    }

    @Override
    public boolean checkUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        Integer a = baseMapper.selectCount(queryWrapper);
        return baseMapper.selectCount(queryWrapper) > 0 ? false : true;
    }

    @Override
    public boolean checkStuNum(String stuNum) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("student_num", stuNum);
        return baseMapper.selectCount(queryWrapper) > 0 ? false : true;
    }
}
