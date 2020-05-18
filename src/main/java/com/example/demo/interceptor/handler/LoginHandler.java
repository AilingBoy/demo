package com.example.demo.interceptor.handler;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.vo.UsersVo;
import com.example.demo.result.JsonResult;
import com.example.demo.service.redis.ContextService;
import com.example.demo.service.redis.RedisService;
import com.example.demo.utils.AesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author AilingBoy
 * https://github.com/AilingBoy
 * @version 1.0
 * @date 2020/5/18 20:57
 */
@Component
@Slf4j
public class LoginHandler extends BaseHandler{
    @Autowired
    private RedisService redisService;

    @Autowired
    private ContextService contextService;

    @Override
    public Boolean getResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getHeader("token");
        if (token == null||redisService.get(token,UsersVo.class)==null) {
            response.setHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE);
            response.getWriter().write(JsonResult.unauth("无权限，请先登陆!").toString());
            return Boolean.FALSE;
        }
        UsersVo usersVo=new UsersVo(token);
        usersVo.setId(token.substring(32));
        contextService.setUser(usersVo);
        return null;
    }

    @Override
    public final int getSort() {
        return 0;
    }

}
