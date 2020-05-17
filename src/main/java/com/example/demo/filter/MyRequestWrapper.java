package com.example.demo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

/**
 * @author AilingBoy
 * https://github.com/AilingBoy
 * @version 1.0
 * @date 2020/5/17 23:00
 */
public class MyRequestWrapper extends HttpServletRequestWrapper {

    private Map<String,String[]> params;

    public MyRequestWrapper(HttpServletRequest request,Map<String,String[]> params) {
        super(request);
        this.params=params;
    }

    @Override
    public Map getParameterMap() {
        return params;
    }

    @Override
    public String getParameter(String name) {
        String[] vs = params.get(name);
        if (vs == null || vs.length < 1)
            return null;
        return vs[0];
    }

    @Override
    public Enumeration getParameterNames() {
        return new Vector(params.keySet()).elements();
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] vs = params.get(name);
        if (vs == null || vs.length < 1)
            return null;
        return vs;
    }
}
