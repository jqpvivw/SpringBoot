package com.jqpv.admin.service.impl;

import com.jqpv.admin.bean.City;
import com.jqpv.admin.mapper.CityMapper;
import com.jqpv.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:CityService
 * Package:com.jqpv.admin.service
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/9 - 16:05
 * @Version:v1.0
 */
@Service
public  class CityServiceImpl implements CityService {
//    @Autowired
//    CityMapper cityMapper;


    @Override
    public City getById(long id) {
        return null;
    }

    @Override
    public void saveCity(City city) {

    }
}
