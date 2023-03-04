package com.jqpv.admin.controller;


import com.jqpv.admin.bean.City;
import com.jqpv.admin.bean.User;

import com.jqpv.admin.service.impl.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * ClassName:IndeController
 * Package:com.jqpv.admin.controller
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/5 - 15:35
 * @Version:v1.0
 */
@Slf4j
@Controller
public class IndexController {


    @Autowired
    CityServiceImpl cityService;

    @Resource
    JdbcTemplate jdbcTemplate;

    @Autowired
    StringRedisTemplate redisTemplate;


    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){

        cityService.saveCity(city);
        return city;
    }



    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }



    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_emp", Long.class);
        return aLong.toString();
    }


    @GetMapping({"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession httpSession, Model model){
        if (StringUtils.hasLength(user.getUserName())&&"123456".equals(user.getPassword())){
            httpSession.setAttribute("loginUser", user);
            return "redirect:/main.html";
        }else {
           model.addAttribute("msg" ,"帐号或者密码错误");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession httpSession,Model model){

        log.info("当前方法是：{}","mainPage");
//        Object loginUser = httpSession.getAttribute("loginUser");
//        if (loginUser != null){
//            return "main";
//        }else {
//            model.addAttribute("msg" ,"请重新登录");
//            return "login";
//        }

        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String s = opsForValue.get("/main.html");
        String s1 = opsForValue.get("/sql");


        model.addAttribute("mainCount",s);
        model.addAttribute("sqlCount",s1);
        return "main";
    }

}
