package com.yxc.system.configuration;

import com.yxc.system.interceptors.AccessControlInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @创建人 杨旭晨
 * @创建时间 2020/7/11 14:33
 * @描述  拦截器
 **/
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new AccessControlInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
