package com.example.demo.service;

import com.example.demo.domain.City;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CityService {

    List<City> findAll();

    City findById(Long id);

    City findByName(String cityName);

    City findByProvinceId(Long id);

    int updateById(City city);

    int deleteById(Long id);

    Long insertCity(City city);
}
