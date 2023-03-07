package com.jqpv.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jqpv.mybatisplus.pojo.City;
import com.jqpv.mybatisplus.service.CityService;
import com.jqpv.mybatisplus.mapper.CityMapper;
import org.springframework.stereotype.Service;

/**
* @author 晚安
* @description 针对表【city】的数据库操作Service实现
* @createDate 2023-02-16 15:29:52
*/
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
    implements CityService{

}




