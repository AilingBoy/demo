package com.example.demo.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.unbescape.xml.XmlEscape;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class JsonResult implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 成功
     */
    private static final Integer SUCCESS = 0;

    /**
     * 请求失败
     */
    private static final Integer FAIL = 1;

    public JsonResult() {
    }

    public JsonResult(Object o) {
        this.code = SUCCESS;
        this.message = "";
        this.data = o;
    }

    public JsonResult(String message) {
        this.code = FAIL;
        this.data = null;
        this.message = message;
    }

    public JsonResult(Throwable e) {
        this.code = FAIL;
        this.data = null;
        this.message = e.getMessage();
    }

    public JsonResult(Integer code, String message, Object data) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static JsonResult data(Object o) {
        return new JsonResult(o);
    }

    public static JsonResult data() {
        return new JsonResult((Object) null);
    }

    public static JsonResult exp(Throwable e) {
        return new JsonResult(e);
    }

    public static JsonResult fail(String message) {
        return new JsonResult(FAIL,message,null);
    }
}
