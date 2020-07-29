package com.yxc.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @创建人 杨旭晨
 * @创建时间 2020/7/19 17:47
 * @描述 打开主页
 **/
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public String index() {
//        ModelAndView mv = new ModelAndView("index");
        return "index.html";
    }

}
