package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class City implements Serializable {
    private static final long serialVersionUID = 5565794179055362587L;
    /**
     * 城市编号
     */
    private Long id;

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

    public City(Long id, Long provinceId, String cityName, String description) {
        this.id = id;
        this.provinceId = provinceId;
        this.cityName = cityName;
        this.description = description;
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
                "id=" + id +
                ", provinceId=" + provinceId +
                ", cityName='" + cityName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}