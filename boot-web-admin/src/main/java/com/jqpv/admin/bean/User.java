package com.jqpv.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Uesr
 * Package:com.jqpv.admin.bean
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/5 - 16:24
 * @Version:v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
//@TableName("")
public class User {

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String password;


    private Long id;
    private String name;
    private Integer age;
    private String email;


}
