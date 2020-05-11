package com.example.demo.service;

import com.example.demo.domain.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    Users findById(String id);

    Boolean updateById(Users users);

    Boolean deleteById(String id);

    String insertUsers(Users users);

    Boolean getByName(String username);
}
