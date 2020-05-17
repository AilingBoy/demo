package com.example.demo.spring;

import com.example.demo.result.JsonResult;
import com.example.demo.utils.AesUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @author AilingBoy
 * https://github.com/AilingBoy
 * @version 1.0
 * @date 2020/5/17 21:06
 */
@ControllerAdvice
public class ResponseBodyEncryptAdvice implements ResponseBodyAdvice {

    //判断是否要执行beforeBodyWrite方法，true为执行，false不执行
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
//        return Objects.requireNonNull(methodParameter.getMethod()).getReturnType().isAssignableFrom(JsonResult.class);
        return false;
    }

    //对response处理的执行方法
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        String key= AesUtil.BASE_KEY;
        try {
            return AesUtil.encryptReturnData((JsonResult) o,key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

