package com.jqpv.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jqpv.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ClassName:UserMapper
 * Package:com.jqpv.mybatisplus.Mapper
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/14 - 13:48
 * @Version:v1.0
 */

@Repository
public interface UserMapper extends BaseMapper<User> {


    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer id);
}
