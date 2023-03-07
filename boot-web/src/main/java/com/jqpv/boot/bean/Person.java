package com.jqpv.boot.bean;

import lombok.Data;

import java.util.Date;

/**
 * ClassName:Person
 * Package:com.jqpv.boot.bean
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/5 - 10:54
 * @Version:v1.0
 */
@Data
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}