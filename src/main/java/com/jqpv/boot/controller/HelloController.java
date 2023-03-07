package com.jqpv.boot.controller;

import com.jqpv.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:HelloController
 * Package:com.jqpv.boot.controller
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/2 - 16:48
 * @Version:v1.0
 */
@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person(){
        return person;

    }
}
