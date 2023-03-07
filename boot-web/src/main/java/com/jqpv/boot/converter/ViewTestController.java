package com.jqpv.boot.converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName:ViewTestContrlooer
 * Package:com.jqpv.boot.converter
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/5 - 15:13
 * @Version:v1.0
 */

@Controller
public class ViewTestController {
    @GetMapping("jqpv")
    public String jqpv(Model model){
        model.addAttribute("msg","你好,JQPV");
        model.addAttribute("link","http://localhost:8080/1.png");
        return "success";
    }

}
