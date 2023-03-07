package com.jqpv.boot.bean;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:Person
 * Package:com.jqpv.boot.bean
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/2 - 16:13
 * @Version:v1.0
 */
@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<Pet>> allPets;


}

