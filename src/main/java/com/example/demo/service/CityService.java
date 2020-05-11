package com.example.demo.service;

import com.example.demo.domain.City;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CityService {

    List<City> findAll();

    City findById(String id);

    City findByName(String cityName);

    City findByProvinceId(String id);

    Boolean updateById(City city);

    Boolean deleteById(String id);

    String insertCity(City city);
}
