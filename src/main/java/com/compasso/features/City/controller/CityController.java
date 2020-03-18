package com.compasso.features.City.controller;

import com.compasso.features.City.dao.CityDao;
import com.compasso.features.City.model.City;
import com.compasso.features.City.service.CityService;
import com.compasso.features.City.vo.CityVO;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {

    final CityDao cityDao;
    final CityService cityService;

    public CityController(CityDao cityDao, CityService cityService) {
        this.cityDao = cityDao;
        this.cityService = cityService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCity() {
        City city = cityDao.getById(1L);
        return city.getName();
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<String> saveCity(@RequestBody CityVO cityVO) {
        try {
            cityService.createCity(cityVO);
            return new ResponseEntity<>("Cidade salva com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Ocorreu um erro ao salvar a cidade", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> getCityByName(@PathVariable("name") String name) {
        try {
            CityVO cityVO = cityService.getByName(name);
            return new ResponseEntity<>(new Gson().toJson(cityVO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Ocorreu um erro ao salvar a cidade", HttpStatus.BAD_REQUEST);
        }
    }
}
