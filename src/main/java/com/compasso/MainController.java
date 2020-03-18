package com.compasso;

import com.compasso.features.City.dao.CityDao;
import com.compasso.features.City.model.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final CityDao cityDao;

    public MainController(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @RequestMapping("/")
    public String index() {
        City city = cityDao.getById(1L);
        return city.getName();
    }
}
