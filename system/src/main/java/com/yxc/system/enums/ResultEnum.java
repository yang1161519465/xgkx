package com.yxc.system.enums;

/**
 * Copyright (C), 2018-2019, 河北地质大学
 * Description:
 *
 * @author 李焕哲
 * @create 2019/8/14 11:12
 */
public enum ResultEnum {
    SUCCESS(0, "success"),
    ERROR(-1, "error"),
    OK(200, "客户端请求已成功"),
    CREATED(201, "已创建"),
    BAD_REQUEST(400, "错误的请求"),
    UNAUTHORIZED(401, "访问被拒绝，权限不足"),
    LOGIN_FAILED(4011, "登录失败"),
    FORBIDDEN(403, "访问被禁止"),
    NOT_FOUND(404, "请求资源未找到"),
    METHOD_NOT_SUPPORT(405, "请求的方法不被允许"),
    INTERNAL_ERROR(500, "内部服务器错误，执行失败"),
    RUNTIME_ERROR(5001, "运行时异常"),
    PARAMETER_ERROR(5002, "参数不能为空或不合法"),
    RECORD_EXIST(5003, "数据库中记录已存在"),
    NULL_EXCEPTION(5004, "null异常"),
    SAFECODE_ERROR(5005, "验证码错误"),
    TOKEN_NULL(50007, "token不能为空"),
    ILLEGAL_TOKEN(50008, "token校验失败"),
    OTHER_LOGINED_IN(50009, "其他用户已登入"),
    TOKEN_EXPIRED(50010, "token已过期"),
    LOGIN_FAIL(5008, "登录失败"),
    GATEWAY_FALLBACK_ERROR(5009, "网关执行请求失败，hystrix服务降级处理"),
    SERVICE_FALLBACK_ERROR(5010, "内部接口暂时不可用，hystrix服务降级处理:"),
    FILE_NOT_FOUND(5011, "文件未找到"),
    FILE_READING_ERROR(5012, "文件读取错误"),
    BUSINESS_ERROR(600, "执行业务异常"),
    PASSWORD_ERROR(5013, "密码输入错误"),
    FILE_EXIST(5014, "文件已存在"),
    SENSITIVE_EXIST(5015, "存在敏感词，请检查"),
    ARTICLECATEGORY_EXIST(5016, "文章类别已存在"),
    CATENAME_EXIST(5017, "文章类别名称已存在");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
