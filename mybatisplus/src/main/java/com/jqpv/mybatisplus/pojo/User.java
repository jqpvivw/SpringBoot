package com.jqpv.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.jqpv.mybatisplus.enums.SexEnum;
import lombok.Data;

/**
 * ClassName:User
 * Package:com.jqpv.mybatisplus.pojo
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/14 - 13:46
 * @Version:v1.0
 */
@Data
//@TableName("user")
public class User {

    //@TableId( value = "id",type = IdType.AUTO)
    private Long id;

   // @TableField()
    private String name;

    private Integer age;

    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;

}
