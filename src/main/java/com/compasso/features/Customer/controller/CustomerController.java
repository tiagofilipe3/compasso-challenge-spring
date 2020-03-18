package com.compasso.features.Customer.controller;

import com.compasso.features.City.dao.CityDao;
import com.compasso.features.City.service.CityService;
import com.compasso.features.City.vo.CityVO;
import com.compasso.features.Customer.service.CustomerService;
import com.compasso.features.Customer.vo.CustomerVO;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  final CustomerService customerService;
  final String ERROR_MSG = "Ocorreu um erro ao salvar o cliente";
  final String CUSTOMER_NOT_FOUND = "O cliente informado não existe no nosso banco de dados";

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(value = "/", method = RequestMethod.PUT)
  public ResponseEntity<String> saveCustomer(@RequestBody CustomerVO customerVO) {
    try {
      customerService.createCustomer(customerVO);
      return new ResponseEntity<>("Cliente salvo com sucesso!", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(ERROR_MSG, HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public ResponseEntity<String> getCustomerByName(@PathVariable("name") String name) {
    try {
      CustomerVO customerVO = customerService.getByName(name);
      return new ResponseEntity<>(new Gson().toJson(customerVO), HttpStatus.OK);
    } catch (NoResultException nre) {
      nre.printStackTrace();
      return new ResponseEntity<>(CUSTOMER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(ERROR_MSG, HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "/byId/{id}", method = RequestMethod.GET)
  public ResponseEntity<String> getCustomerById(@PathVariable("id") Long id) {
    try {
      CustomerVO customerVO = customerService.getById(id);
      return new ResponseEntity<>(new Gson().toJson(customerVO), HttpStatus.OK);
    } catch (NoResultException nre) {
      nre.printStackTrace();
      return new ResponseEntity<>(CUSTOMER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(ERROR_MSG, HttpStatus.BAD_REQUEST);
    }
  }
}
