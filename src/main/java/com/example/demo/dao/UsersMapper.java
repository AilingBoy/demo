package com.example.demo.dao;

import com.example.demo.domain.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

    void add(Users users);

    void delete(String id);

    void update(Users users);

    Users get(String id);

    Users getByName(String username);
}
