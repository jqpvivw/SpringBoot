package com.jqpv.admin.service;

import com.jqpv.admin.bean.City;

/**
 * ClassName:CityService
 * Package:com.jqpv.admin.service
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/10 - 10:13
 * @Version:v1.0
 */
public interface CityService {
    public City getById(long id);

    public void saveCity(City city) ;
;
}
