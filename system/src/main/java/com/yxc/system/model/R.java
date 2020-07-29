package com.yxc.system.model;

import cn.hutool.core.date.DateTime;
import com.yxc.system.enums.ResultEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 杨旭晨
 * @创建时间 2020/7/19 18:22
 * @描述 返回数据的模板类
 **/
public class R extends HashMap<String, Object> {
    //
    private static final long serialVersionUID = -8157613083634272196L;

    public R() {
        put("code", ResultEnum.SUCCESS.getCode());
        put("msg", ResultEnum.SUCCESS.getMsg());
        put("timestamp", DateTime.now());
    }

    public static R error() {
        return error(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg());
    }

    public static R error(String msg) {
        return error(ResultEnum.INTERNAL_ERROR.getCode(), msg);
    }

    public static R error(ResultEnum res) {
        return error(res.getCode(), res.getMsg());
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error(int code, String msg, String path) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("path", path);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg, Object data) {
        R r = new R();
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public int getCode() {
        return (int) super.get("code");
    }

    public String getMsg() {
        return (String) super.get("msg");
    }
}

