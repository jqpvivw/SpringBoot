package com.jqpv.mybatisplus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jqpv.mybatisplus.pojo.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 晚安
* @description 针对表【city】的数据库操作Mapper
* @createDate 2023-02-16 15:29:52
* @Entity com.jqpv.mybatisplus.pojo.City
*/
public interface CityMapper extends BaseMapper<City> {

    int insertSelective(City city);

    int deleteByIdAndName(@Param("id") Integer id, @Param("name") String name);

    int updateNameById(@Param("name") String name, @Param("id") Integer id);

    List<City> selectStateAndNameById(@Param("id") Integer id);


}




