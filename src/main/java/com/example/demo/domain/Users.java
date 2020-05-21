package com.example.demo.domain;

import com.example.demo.base.BaseModel;
import lombok.Data;

/**
 * @author AilingBoy
 */
@Data
public class Users extends BaseModel {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


    public Users(){}

    public Users(String username,String password){
        this.username=username;
        this.password=password;
    }
}
