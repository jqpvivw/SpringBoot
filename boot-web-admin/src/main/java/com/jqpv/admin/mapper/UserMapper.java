package com.jqpv.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jqpv.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName:UserMapper
 * Package:com.jqpv.admin.mapper
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/10 - 9:58
 * @Version:v1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
