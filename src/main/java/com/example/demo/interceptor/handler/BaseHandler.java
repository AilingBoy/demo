package com.example.demo.interceptor.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class BaseHandler implements BaseHandlerInteface {

    /**
     * 不允许被重载
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public final Boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Boolean result = getResult(request,response);
        if(null != result){
            return result;
        }
        if(null != getExtenHandles() && getExtenHandles().size()>0){
            for(BaseHandlerInteface handlerInteface: getExtenHandles()){
                if(handlerInteface.equals(this)){
                    continue;
                }
                result = handlerInteface.getResult(request,response);
                if(null != result){
                    return result;
                }
            }
        }
        return result;
    }

}