package com.example.demo.base;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseModel implements Serializable {

    /**
     * 谨慎改动
     */
    private static final long serialVersionUID = -1234567890L;

    /**
     * 主键id
     */
    private String id;

    public BaseModel() {
    }

    public BaseModel(String id) {
        this.id = id;
    }

    /**
     * 生成主键id
     */
    public static String getUUID() {
        return IdUtil.simpleUUID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /**
     * 创建主键id
     */
    public void generateId() {
        this.id =IdUtil.simpleUUID();
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id='" + id + '\'' +
                '}';
    }
}
