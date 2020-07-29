package com.yxc.system.service;

import com.yxc.system.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  用户表服务类
 * </p>
 *
 * @author 杨旭晨
 * @since 2020-07-25
 */
public interface UserService extends IService<User> {

    /**
     * @author 杨旭晨
     * @Description 根据条件查询用户
     * @Date 8:40 2020/7/28
     * @Param queryUser: 查询条件
     * @return java.util.List<com.yxc.system.model.User>
     * @update
     **/
    List<User> list(User queryUser);

    /**
     * @author 杨旭晨
     * @Description 检查用户名是否可用
     * @Date 14:45 2020/7/28
     * @Param username: 要检查的用户名
     * @return boolean true：可用，false：不可用
     * @update
     **/
    boolean checkUsername(String username);

    /**
     * @author 杨旭晨
     * @Description 检查学号是否重复
     * @Date 14:46 2020/7/28
     * @Param stuNum: 要检查的学号
     * @return boolean true：不重复， false：重复
     * @update
     **/
    boolean checkStuNum(String stuNum);

}
