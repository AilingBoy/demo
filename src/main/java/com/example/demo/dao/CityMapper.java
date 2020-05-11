package com.example.demo.dao;

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CityMapper {
    List<City> findAll();

    City findById(String id);

    City findByName(String cityName);

    City findByProvinceId(String id);

    void updateById(City city);

    void deleteById(String id);

    void insertCity(City city);
}
