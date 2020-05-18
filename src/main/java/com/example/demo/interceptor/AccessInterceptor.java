package com.example.demo.interceptor;

import com.example.demo.interceptor.handler.BaseHandler;
import com.example.demo.interceptor.handler.BaseHandlerInteface;
import com.example.demo.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Component
@Slf4j
public class AccessInterceptor implements HandlerInterceptor {

    @Autowired
    private List<BaseHandler> list;

    private List<BaseHandler> sortedHandlers;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Request URL : {},IP Address : {}", request.getRequestURI(), RequestUtil.getIpAddress(request));
        if(null == sortedHandlers){
            sortedHandlers = BaseHandlerInteface.getHandlers(list);
        }
        for(BaseHandler baseHandler: sortedHandlers){
            Boolean result = baseHandler.execute(request,response);
            if(null == result){
                continue;
            }
            return result;
        }
        return Boolean.TRUE;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}