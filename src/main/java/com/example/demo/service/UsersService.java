package com.example.demo.service;

import com.example.demo.domain.Users;
import com.example.demo.domain.vo.UsersVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface UsersService {

    Users findById(String id) throws Exception;

    Boolean updateById(Users users) throws Exception;

    Boolean deleteById(String id) throws Exception;

    String insertUsers(Users users) throws Exception;

    Boolean getByName(String username) throws Exception;

    UsersVo login(String username, String password) throws Exception;

    Boolean logout(HttpServletRequest request) throws Exception;
}
