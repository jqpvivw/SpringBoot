package com.jqpv.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jqpv.mybatisplus.mapper.ProductMapper;
import com.jqpv.mybatisplus.pojo.Product;
import com.jqpv.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * ClassName:ProductServiceImpl
 * Package:com.jqpv.mybatisplus.service.impl
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/16 - 15:08
 * @Version:v1.0
 */

@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
