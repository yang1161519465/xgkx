package com.yxc.system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.alibaba.fastjson.JSONObject;
import com.yxc.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api(description = "登陆管理接口")
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取验证码", notes="获取登陆验证码")
    @GetMapping("code")
    @ResponseBody
    public JSONObject code() throws Exception {
        JSONObject json = new JSONObject();

        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(150, 50);
        json.put("code", captcha.getCode());
        json.put("codeImg", captcha.getImageBase64());
        return json;
    }

}
