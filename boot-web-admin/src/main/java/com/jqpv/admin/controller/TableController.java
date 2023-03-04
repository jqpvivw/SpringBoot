package com.jqpv.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jqpv.admin.bean.User;
import com.jqpv.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:TableController
 * Package:com.jqpv.admin.controller
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/5 - 17:02
 * @Version:v1.0
 */
@Controller
public class TableController {

    @Resource
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value="pn",defaultValue = "1") Integer pn, Model model){
//
//        List<User> users = Arrays.asList(new User("胡桃", "46322"),
//                new User("甘雨", "45678976"),
//                new User("公子", "3243534"),
//                new User("凝光","78007565888"));
//
//        model.addAttribute("users", users);

       // List<User> list = userService.list();
        //model.addAttribute("users", list);


//        Page<User> userPage = new Page<>(pn,2);
//        Page<User> page = userService.page(userPage, null);
//        long current = page.getCurrent();
//        long pages = page.getPages();
//        long total = page.getTotal();
//        List<User> records = page.getRecords();
//
//
//        model.addAttribute("page", page);

        //构造分页参数
        Page<User> page = new Page<>(pn, 5);
        //调用page进行分页
        Page<User> userPage = userService.page(page, null);
        model.addAttribute("users",userPage);

        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@RequestParam("id") long id ,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);
        redirectAttributes.addAttribute("pn",pn);


        return "redirect:/dynamic_table";
    }



    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
