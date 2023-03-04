package com.jqpv.admin.mapper;

import com.jqpv.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName:CityMapper
 * Package:com.jqpv.admin.mapper
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/9 - 15:59
 * @Version:v1.0
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getById(Long id);


    @Insert("insert into  city(`name`,`state`,`country`) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);

}
