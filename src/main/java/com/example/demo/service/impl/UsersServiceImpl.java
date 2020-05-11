package com.example.demo.service.impl;

import com.example.demo.dao.UsersMapper;
import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper um;

    @Override
    public Users findById(String id) {
        return um.get(id);
    }

    @Override
    public Boolean updateById(Users users) {
        um.update(users);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteById(String id) {
        um.delete(id);
        return Boolean.TRUE;
    }

    @Override
    public String insertUsers(Users users) {
        users.generateId();
        um.add(users);
        return users.getId();
    }

    @Override
    public Boolean getByName(String username) {
        Users u=um.getByName(username);
        if(u!=null)
            return Boolean.FALSE;
        else
            return Boolean.TRUE;
    }
}
