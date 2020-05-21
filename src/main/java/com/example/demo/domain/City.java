package com.example.demo.domain;

import com.example.demo.base.BaseModel;
import lombok.Data;


/**
 * @author AilingBoy
 */
@Data
public class City extends BaseModel {
    private static final long serialVersionUID = 5565794179055362587L;
    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;


    public City() {
    }

    public City(Long provinceId, String cityName, String description) {
        this.provinceId = provinceId;
        this.cityName = cityName;
        this.description = description;
    }

    public City(String cityName, String description) {
        this.cityName = cityName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + super.getId() +
                ", provinceId=" + provinceId +
                ", cityName='" + cityName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}