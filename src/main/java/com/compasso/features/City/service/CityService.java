package com.compasso.features.City.service;

import com.compasso.features.City.dao.CityDao;
import com.compasso.features.City.model.City;
import com.compasso.features.City.vo.CityVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    final
    CityDao cityDao;


    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public void createCity(CityVO cityVO) {
        City city = new City();
        city.setName(cityVO.getName());
        city.setState(cityVO.getState());

        cityDao.createCity(city);
    }

    public CityVO getByName(String name) {
        City city = cityDao.getByName(name);
        return new CityVO(city);
    }

    public List<CityVO> getByState(String state) {
        List<City> cities = cityDao.getByState(state);
        List<CityVO> cityVOS = new ArrayList<>();

        for (City city : cities) {
            CityVO cityVO = new CityVO(city);
            cityVOS.add(cityVO);
        }

        return cityVOS;
    }
}
