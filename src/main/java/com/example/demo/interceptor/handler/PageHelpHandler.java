package com.example.demo.interceptor.handler;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class PageHelpHandler extends BaseHandler {

    @Override
    public Boolean getResult(HttpServletRequest request, HttpServletResponse response) {
        String requestUrl = request.getRequestURI();
        if (!requestUrl.equals("/")&&!requestUrl.equals("/city")) {
            return Boolean.TRUE;
        }
        Integer pageSize;
        Integer pageNum;
        String pz = request.getParameter("pageSize");
        if (pz == null) {
            pageSize = 10;
        } else {
            pageSize = Integer.valueOf(pz);
            if (pageSize < 1 || pageSize > 500) {
                pageSize = 10;
            }
        }
        String pn = request.getParameter("pageNum");
        if (null == pn) {
            pageNum = 1;
        } else {
            pageNum = Integer.valueOf(pn);
            pageNum = pageNum < 1 ? 1 : pageNum;
        }
        PageHelper.startPage(pageNum, pageSize);
        return Boolean.TRUE;
    }

    @Override
    public int getSort() {
        return 9;
    }
}
