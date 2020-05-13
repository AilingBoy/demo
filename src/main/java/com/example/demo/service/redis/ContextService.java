package com.example.demo.service.redis;

import com.example.demo.domain.vo.UsersVo;
import org.springframework.stereotype.Service;

/**
 * @author AilingBoy
 * https://github.com/AilingBoy
 * @version 1.0
 * @date 2020/5/12 21:00
 */
@Service
public class ContextService {

    private static ThreadLocal<UsersVo> usersThreadLocal=new ThreadLocal<>();

    public void setUser(UsersVo users){
        usersThreadLocal.set(users);
    }

    public UsersVo get(){
        return usersThreadLocal.get();
    }

    public void clean(){
        usersThreadLocal.remove();
    }
}
