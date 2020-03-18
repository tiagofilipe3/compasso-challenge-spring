package com.compasso.features.City.service;

import com.compasso.features.City.dao.CityDao;
import com.compasso.features.City.model.City;
import com.compasso.features.City.vo.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        CityVO cityVO = new CityVO(city);
        return cityVO;
    }
}
