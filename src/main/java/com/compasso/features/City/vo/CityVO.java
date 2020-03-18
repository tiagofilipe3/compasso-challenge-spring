package com.compasso.features.City.vo;

import com.compasso.features.City.model.City;

public class CityVO {
    private String name;
    private String state;

    public CityVO() {

    }

    public CityVO(City city) {
        setName(city.getName());
        setState(city.getState());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
