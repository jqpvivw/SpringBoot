package com.jqpv.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.jqpv.mybatisplus.enums.SexEnum;
import com.jqpv.mybatisplus.mapper.ProductMapper;
import com.jqpv.mybatisplus.mapper.UserMapper;
import com.jqpv.mybatisplus.pojo.Product;
import com.jqpv.mybatisplus.pojo.User;
import com.jqpv.mybatisplus.service.ProductService;
import com.jqpv.mybatisplus.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.Year;
import java.util.*;

/**
 * ClassName:MyBatisPlusTset
 * Package:com.jqpv.mybatisplus
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/14 - 14:30
 * @Version:v1.0
 */
@SpringBootTest
public class MyBatisPlusTset {

    @Autowired
    @Resource
    UserMapper userMapper;

    @Test
    public void testSelectList(){

        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(19);
        user.setEmail("dsfjs@.com");
        user.setName("fjj");
        int insert = userMapper.insert(user);
        System.out.println(insert);

    }

    @Test
    public void testDelete(){
//        int i = userMapper.deleteById(1626092708567302146L);
//        System.out.println(i);

        List<Long> longs = Arrays.asList(11l, 2l);
        int i = userMapper.deleteBatchIds(longs);
        System.out.println(i);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setEmail("1232@qq.com");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }


    @Test
    public void testSelect(){
        Map<String,Object> map =new HashMap<>();
        map.put("name","fjj");
        map.put("age",19);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }


    @Autowired
    UserService userService;

    @Test
    public void  testGetCount(){
        int count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testInsertMore(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            User user = new User();
            user.setName("ljs"+i);
            user.setAge(19+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }


    @Test
    public void test1(){
        String username = "f";
        Integer ageBegin = null;
        Integer ageEnd = 19;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(username),"name",username)
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd !=null,"age",ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void testPage(){

        Page<User> page =new Page<>(1,3);

        userMapper.selectPage(page,null);

        System.out.println(page);

    }


    @Test
    public void testPageVo(){
      Page<User> page =new Page<>(1,3);
        userMapper.selectPageVo(page,19);
        System.out.println(page.getTotal());

    }


    @Autowired
    ProductMapper productMapper;

    @Test
    public void testProduct(){
        //1.小李获取商品价格
        Product product = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为："+product.getPrice());

        //2.小王获取商品价格
        Product product1 = productMapper.selectById(1);
        System.out.println("小王获取的商品价格为："+product1.getPrice());

        //3.小李修改商品价格+50
        product.setPrice(product.getPrice()+50);
        productMapper.updateById(product);

        //4.小王修改商品价格-30
        product1.setPrice(product1.getPrice()-30);
        int i = productMapper.updateById(product1);

        if(i == 0){
            Product product2 = productMapper.selectById(1);
            product2.setPrice(product2.getPrice()-30);
            productMapper.updateById(product2);
        }

        //5.老板查询商品价格
        Product productBoob = productMapper.selectById(1);
        System.out.println("老板获取的商品价格为："+productBoob.getPrice());
    }

    @Test
    public void testSex(){
        User user =new User();
        user.setAge(23);
        user.setName("admin");
        //user.setIsDeleted(0);
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void FastAutoGeneratorTest(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("jqpv") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\mybatisplus"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.jqpv") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\mybatisplus")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    @Resource
    ProductService productService;

    @Test
    void contextLoads() {
        User user = userService.getById(1L);
        Product product = productService.getById(1L);
        System.out.println("User = " + user);
        System.out.println("Product = " + product);
    }


}
