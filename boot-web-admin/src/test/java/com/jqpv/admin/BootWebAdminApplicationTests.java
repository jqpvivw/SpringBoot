package com.jqpv.admin;

import com.jqpv.admin.bean.User;
import com.jqpv.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class BootWebAdminApplicationTests {


    //@Autowired
    @Resource
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_emp", Long.class);
        log.info("总数:{}",aLong);
        log.info("总数1:{}",dataSource.getClass());
    }


    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用户信息{}",user);
    }

//    @Test
//    void testRedis(){
//       ValueOperations<String, String> operations = redisTemplate.opsForValue();
//       operations.set("你好","fjj");
//        String hj = operations.get("你好");
//        System.out.println(hj);
//
//    }
}
