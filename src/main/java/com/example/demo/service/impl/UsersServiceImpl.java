package com.example.demo.service.impl;

import cn.hutool.core.util.IdUtil;
import com.example.demo.dao.UsersMapper;
import com.example.demo.domain.Users;
import com.example.demo.domain.vo.UsersVo;
import com.example.demo.service.UsersService;
import com.example.demo.service.redis.ContextService;
import com.example.demo.service.redis.RedisService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper um;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ContextService contextService;

    @Override
    public Users findById(String id) throws Exception{
        return um.get(id);
    }

    @Override
    public Boolean updateById(Users users) throws Exception{
        um.update(users);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteById(String id) throws Exception{
        um.delete(id);
        return Boolean.TRUE;
    }

    @Override
    public String insertUsers(Users users) throws Exception{
        users.generateId();
        um.add(users);
        return users.getId();
    }

    @Override
    public Boolean getByName(String username) throws Exception{
        UsersVo u=um.getByName(username);
        if(u!=null)
            return Boolean.FALSE;
        else
            return Boolean.TRUE;
    }

    @Override
    public UsersVo login(String username, String password) throws Exception{
        UsersVo u = um.getByName(username);
        if(u==null){

            throw new Exception("用户名不存在");
        }
        if(!u.getPassword().equals(password)){
            throw new Exception("密码错误");
        }
        String key=u.getId()+"_"+IdUtil.simpleUUID();
        u.setToken(key);
        String oldKey=redisService.get(u.getId(),String.class);
        if(oldKey!=null){
            redisService.remove(oldKey);
        }
        redisService.put(u.getId(),key);
        redisService.put(key,u);
        return u;
    }

    @Override
    public Boolean logout(HttpServletRequest request) throws Exception{
        String token = request.getHeader("token");
        UsersVo usersVo = redisService.get(token, UsersVo.class);
        redisService.remove(token);
        redisService.remove(usersVo.getId());
        return Boolean.TRUE;
    }
}
