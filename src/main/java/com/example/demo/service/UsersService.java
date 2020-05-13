package com.example.demo.service;

import com.example.demo.domain.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    Users findById(String id) throws Exception;

    Boolean updateById(Users users) throws Exception;

    Boolean deleteById(String id) throws Exception;

    String insertUsers(Users users) throws Exception;

    Boolean getByName(String username) throws Exception;

    Boolean login(String username,String password) throws Exception;

    Boolean logout() throws Exception;
}
