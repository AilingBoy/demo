package com.example.demo.interceptor;

import com.example.demo.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@Slf4j
public class AccessInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AccessInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Request URL : {},IP Address : {}", request.getRequestURI(), RequestUtil.getIpAddress(request));
//        String token = request.getHeader("token");
//        if (token == null) {
//            response.setHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE);
//            response.getWriter().write("请先登录!");
//            return Boolean.FALSE;
//        }
        return Boolean.TRUE;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


}