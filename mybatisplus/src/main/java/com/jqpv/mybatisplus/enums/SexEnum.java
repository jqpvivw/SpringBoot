package com.jqpv.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * ClassName:SexEnum
 * Package:com.jqpv.mybatisplus.enums
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/16 - 13:17
 * @Version:v1.0
 */

@Getter
public enum SexEnum {

    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue
    private Integer sex;
    private String sexName;

     SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
