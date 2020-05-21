package com.example.demo.filter;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @author AilingBoy
 * https://github.com/AilingBoy
 * @version 1.0
 * @date 2020/5/17 23:10
 */
@WebFilter(urlPatterns = "/*")
@Slf4j
public class MyFilter implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Map<String, String[]> map = new HashMap<>(request.getParameterMap());
        removeEmptyParam(map);
        request=new MyRequestWrapper(request,map);
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }

    public void removeEmptyParam(Map<String, String[]> param) {
        List<String> strings = Lists.newArrayList(param.keySet());
        for (String key : strings) {
            if (null == param.get(key)) {
                param.remove(key);
            }
            String[] objects = param.get(key);
            int index = 0;
            if (objects[0] != null) {
                for (int i = 0; i < objects.length; i++) {
                    String value = objects[i].trim();
                    objects[i] = null;
                    if (value.length() > 0) {
                        objects[index] = value;
                        index++;
                    }
                }
                if (null == objects[0]) {
                    param.remove(key);
                } else {
                    param.put(key, objects);
                }
            }
        }
    }
}
