package com.example.demo.controller;

import com.example.demo.domain.Users;
import com.example.demo.domain.vo.UsersVo;
import com.example.demo.result.JsonResult;
import com.example.demo.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author AilingBoy
 * https://github.com/AilingBoy
 * @version 1.0
 * @date 2020/5/12 22:38
 */
@RestController
@Api(value = "用户",tags = "用户管理")
public class UsersController {

    @Autowired
    UsersService us;

//    @ApiOperation("查询用户")
//    @ApiOperation("修改用户")
//    @ApiOperation("删除用户")
//    @ApiOperation("通过username查询用户")

    @ApiOperation("用户登陆")
    @PostMapping("/login")
    public JsonResult login(String username, String password) throws Exception {
        return JsonResult.data(us.login(username, password));
    }

    @ApiOperation("用户登出")
    @PostMapping("/logout")
    public JsonResult logout() throws Exception {
        return JsonResult.data(us.logout());
    }

    @ApiOperation("添加用户")
    @PostMapping("/users")
    public JsonResult add(Users u) throws Exception {
        return JsonResult.data(us.insertUsers(u));
    }
}
