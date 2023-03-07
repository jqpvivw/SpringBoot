package com.jqpv.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jqpv.mybatisplus.mapper.UserMapper;
import com.jqpv.mybatisplus.pojo.User;
import com.jqpv.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Package:com.jqpv.mybatisplus.service.impl
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/14 - 15:46
 * @Version:v1.0
 */


@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
