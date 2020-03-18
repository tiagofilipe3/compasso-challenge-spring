package com.compasso.features.Customer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
  @Id
  @GeneratedValue(
          strategy = GenerationType.IDENTITY
  )
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "sex", nullable = false)
  private Integer sex;

  @Column(name = "birthdate", nullable = false)
  private Date birthdate;

  @Column(name = "age", nullable = false)
  private Integer age;

  @Column(name = "city", nullable = false)
  private String city;

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

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
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
