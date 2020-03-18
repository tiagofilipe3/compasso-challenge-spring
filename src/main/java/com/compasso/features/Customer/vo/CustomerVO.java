package com.compasso.features.Customer.vo;

import com.compasso.features.City.model.City;
import com.compasso.features.Customer.model.Customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerVO {
  private Long id;
  private String name;
  private Integer sex;
  private String birthdate;
  private Integer age;
  private String city;

  public CustomerVO() {

  }

  public CustomerVO(Customer customer) {
    this.setId(customer.getId());
    this.setName(customer.getName());
    this.setSex(customer.getSex());
    this.setBirthdate(customer.getBirthdate().toString());
    this.setAge(customer.getAge());
    this.setCity(customer.getCity());
  }

  public Customer toUser() throws ParseException {
    Customer customer = new Customer();
    customer.setId(this.getId());
    customer.setName(this.getName());
    customer.setSex(this.getSex());

    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
    customer.setBirthdate(dateFormat.parse(this.getBirthdate()));
    customer.setAge(this.getAge());
    customer.setCity(this.getCity());

    return customer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
