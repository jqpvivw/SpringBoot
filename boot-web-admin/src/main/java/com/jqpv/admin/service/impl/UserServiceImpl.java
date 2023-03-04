package com.jqpv.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jqpv.admin.bean.User;
import com.jqpv.admin.mapper.UserMapper;
import com.jqpv.admin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Package:com.jqpv.admin.service.impl
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/10 - 10:12
 * @Version:v1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
