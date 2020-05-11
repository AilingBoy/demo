package com.example.demo.service.impl;

import com.example.demo.dao.CityMapper;
import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import com.example.demo.service.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CityServiceImpl implements CityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityMapper cm;

    @Autowired
    private RedisService redisService;

    @Override
    public List<City> findAll() {
        return cm.findAll();
    }

    @Override
    public City findById(String id) {
        String key = getString(id);
        City city = redisService.get(key, City.class);
        if (city != null) {
            LOGGER.info("CityServiceImpl.findById() 从缓存获取到了" + city.toString());
            return city;
        } else {
            city = cm.findById(id);
            redisService.put(key, city);
            LOGGER.info("CityServiceImpl.findById() 从数据库获取到了" + city.toString() + ",并将其插入缓存");
            return city;
        }
    }

    @Override
    public City findByName(String cityName) {
        return cm.findByName(cityName);
    }

    @Override
    public City findByProvinceId(String id) {
        return cm.findByProvinceId(id);
    }

    @Override
    public Boolean updateById(City city) {
        cm.updateById(city);
        String id = city.getId();
        String key = getString(id);
        City c = redisService.get(key, city.getClass());
        if (c != null) {
            redisService.remove(key);
            redisService.put(key, city);
            LOGGER.info("将原来的老数据从缓存中删除，并将新的数据插入缓存" + city.toString());
        } else {
            redisService.put(key, city);
            LOGGER.info("将此次更新的数据插入缓存" + city.toString());
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteById(String id) {
        cm.deleteById(id);
        String key = getString(id);
        redisService.remove(key);
        LOGGER.info("将数据从缓存中删除,id为"+key);
        return Boolean.TRUE;
    }

    @Override
    public String insertCity(City city) {
        city.generateId();
        cm.insertCity(city);
        String key = getString(city.getId());
        redisService.put(key,city);
        return city.getId();
    }

    private String getString(String id) {
        return "city_" + id;
    }
}
