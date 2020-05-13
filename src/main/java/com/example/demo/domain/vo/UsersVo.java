package com.example.demo.domain.vo;

import com.example.demo.domain.Users;
import lombok.Data;

/**
 * @author AilingBoy
 * https://github.com/AilingBoy
 * @version 1.0
 * @date 2020/5/12 22:12
 */
@Data
public class UsersVo extends Users {
    /**
     * 校验码
     */
    private String token;
}
