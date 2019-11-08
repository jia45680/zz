package com.lan.zz.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConf implements WebMvcConfigurer {

    @Autowired
    private InterceptorConf ic;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("loginPage");
        registry.addViewController("/index.html").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(ic);

        ir.addPathPatterns("/**");

        ir.excludePathPatterns("/js/**");
        ir.excludePathPatterns("/css/**");

        ir.excludePathPatterns("/");
        ir.excludePathPatterns("/login.html");
        ir.excludePathPatterns("/error/**");
        ir.excludePathPatterns("/customer/login");
    }
}
