package com.jqpv.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * ClassName:Product
 * Package:com.jqpv.mybatisplus.pojo
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/16 - 12:27
 * @Version:v1.0
 */
@Data
//@TableName("t_product")
public class Product {
    private Long id;
    private String name;
    private Integer price;

    @Version
    private Integer version;
}
