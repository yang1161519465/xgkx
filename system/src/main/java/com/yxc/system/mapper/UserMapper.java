package com.yxc.system.mapper;

import com.yxc.system.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨旭晨
 * @since 2020-07-25
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * @author 杨旭晨
     * @Description 根据条件查找用户列表
     * @Date 8:41 2020/7/28
     * @Param user: 查找条件
     * @return java.util.List<com.yxc.system.model.User>
     * @update
     **/
    List<User> list(User user);

}
