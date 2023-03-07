package com.jqpv.boot.controller;

import ch.qos.logback.classic.spi.STEUtil;
import com.jqpv.boot.bean.Person;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ParameterTestController
 * Package:com.jqpv.boot.controller
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/3 - 14:31
 * @Version:v1.0
 */
@RestController
public class ParameterTestController {

    @ResponseBody
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }

    @GetMapping("car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id ,
                                     @PathVariable("username")String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String, String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params){
        Map<String,Object> map = new HashMap<>();
        //map.put("id",id);
        map.put("name",name);
        //map.put("pv",pv);
        //map.put("userAgent",userAgent);
        //map.put("header" ,header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);

        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        System.out.println(URLDecoder.decode(content));
        return map;
    }


//    /cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                       @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("brand" ,brand);
        map.put("low",low);
        map.put("path",path);
        return map;
    }

//    boss/1;age=20/2;age=10
    @RequestMapping("/boss/{bossId}/{empId}")
    public Map boss( @MatrixVariable(value = "age",pathVar = "bossId") Integer bosAge ,
                     @MatrixVariable(value = "age",pathVar = "empId")Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bosAge",bosAge);
        map.put("empAge",empAge);
        return map;
    }
}
