package com.jqpv.admin.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:RedisUrlCountInterceptor
 * Package:com.jqpv.admin.interceptor
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/20 - 18:32
 * @Version:v1.0
 */

@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        redisTemplate.opsForValue().increment(requestURI);


    return true;
    }
}
