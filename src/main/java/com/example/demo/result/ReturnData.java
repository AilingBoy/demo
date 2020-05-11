package com.example.demo.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class ReturnData<T> implements Serializable {

    private static final long serialVersionUID = -4577255781088498763L;
    /**
     * 成功
     */
    private static final int SUCCESS = 0;
    /**
     * 请求失败
     */
    private static final int FAIL = 1;
    /**
     * 无权限
     */
    private static final int DENY = 2;
    /**
     * 未登录，需要登录
     */
    private static final int UNAUTH = -1;

    /**
     * 服务端数据
     */
    private T data;

    /**
     * 状态码
     */
    private int code = SUCCESS;

    /**
     * 成功是 true,  失败是 false
     */
    private Boolean status;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 异常错误堆栈的详细信息
     */
    private String detail;

    /**
     * 时间戳
     */
    private Long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

    public ReturnData(Object o) {
        if (o != null && o instanceof Throwable) {
            this.code = FAIL;
            this.status = false;
            this.msg = "Server Interal error";
            this.detail = o != null ? ((Throwable) o).getMessage() : "";
            this.data = null;
        } else {
            this.status = true;
            this.code = SUCCESS;
            this.msg = "success";
            this.detail = "";
            this.data = (T) o;
        }
    }

    public ReturnData(String msg, String detail) {
        this.code = FAIL;
        this.status = false;
        this.msg = msg;
        this.detail = detail;
        this.data = null;
    }

    public ReturnData(String msg, Throwable e) {
        this.code = FAIL;
        this.status = false;
        this.msg = msg;
        this.detail = e != null ? e.toString() : "";
        this.data = null;
    }

    public ReturnData(int code, Boolean status, String msg, String detail, T data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.detail = detail;
        this.data = data;
    }

    ///////////////////////////常用的方法////////////////////////////////

    public static ReturnData ok() {
        return data();
    }

    public static ReturnData ok(Object d) {
        return data(d);
    }

    public static ReturnData unauth(String msg) {
        return new ReturnData(ReturnData.UNAUTH, false, msg, msg, null);
    }


///////////////////////////基本的方法////////////////////////////////

    public static ReturnData deny(String msg) {
        return new ReturnData(ReturnData.DENY, false, msg, msg, null);
    }

    public static ReturnData data() {
        return new ReturnData(null);
    }

    public static ReturnData data(Object data) {
        return new ReturnData(data);
    }

    public static ReturnData exp(Throwable e) {
        return new ReturnData(e);
    }
}