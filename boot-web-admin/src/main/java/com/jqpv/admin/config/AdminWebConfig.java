package com.jqpv.admin.config;

import com.jqpv.admin.interceptor.LoginInterceptor;
import com.jqpv.admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:AdminWebConfig
 * Package:com.jqpv.admin.config
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/7 - 11:35
 * @Version:v1.0
 */
@Controller
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fonts/**");

        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fonts/**");
    }

}
