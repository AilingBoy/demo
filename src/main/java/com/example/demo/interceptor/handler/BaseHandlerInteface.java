package com.example.demo.interceptor.handler;

import com.google.common.collect.Lists;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public interface BaseHandlerInteface {

    default List<BaseHandlerInteface> getExtenHandles(){
        return null;
    }

    Boolean getResult(HttpServletRequest request, HttpServletResponse response)throws Exception;

    /**
     *
     * @return handler 处理的优先级,禁止使用含有0的数字作为序号
     */
    int getSort();

    /**
     * 获取处理器
     * @param handlers
     * @return
     */
    static List<BaseHandler> getHandlers(List<BaseHandler> handlers){
        Map<String, BaseHandler> handlerMap = new TreeMap<>();
        handlers.forEach(e ->{
            handlerMap.put(getBuffer(new StringBuffer().append(e.getSort())).toString(),e);
        });
        return Lists.newArrayList(handlerMap.values());
    }

    static StringBuffer getBuffer(StringBuffer buffer){
        buffer.append("0");
        if(buffer.length() < 8){
            return getBuffer(buffer);
        }
        return buffer;
    }

}
