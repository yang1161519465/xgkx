package com.yxc.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *      用户表实体类
 * </p>
 *
 * @author 杨旭晨
 * @since 2020-07-25
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录名（昵称）
     */
    private String username;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学院
     */
    private String college;

    /**
     * 班级
     */
    private String className;

    /**
     * 学号
     */
    private String studentNum;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码（hash加密）
     */
    private String passwordHash;

    /**
     * 地理位置
     */
    private String location;

    /**
     * 个人介绍
     */
    private String aboutMe;

    /**
     * 邮箱验证
     */
    private Integer confirmed;

}
