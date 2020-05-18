package com.example.demo.service.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Redis存储
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean put(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(value));
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Boolean.TRUE;
        }
    }

    /**
     * Redis存储,设置有效时间
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean put(String key, Object value, Long expireTime) {
        try {
            redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(value));
            if (expireTime != null) {
                redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Boolean.TRUE;
        }
    }

    /**
     * Redis读取
     *
     * @param key
     * @return
     */
    public <T> T get(String key, Class<T> t) {
        try {
            if (!redisTemplate.hasKey(key)) {
                return null;
            } else {
                return objectMapper.readValue(redisTemplate.opsForValue().get(key), t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除Key
     *
     * @param key
     * @return
     */
    public Boolean remove(String key) {
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
        }
        return Boolean.TRUE;
    }
}
