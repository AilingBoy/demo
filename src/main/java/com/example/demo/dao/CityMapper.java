package com.example.demo.dao;

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CityMapper {
    List<City> findAll();

    City findById(Long id);

    City findByName(String cityName);

    City findByProvinceId(Long id);

    int updateById(City city);

    int deleteById(Long id);

    int insertCity(City city);
}
