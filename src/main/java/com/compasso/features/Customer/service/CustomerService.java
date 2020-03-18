package com.compasso.features.Customer.service;

import com.compasso.features.Customer.dao.CustomerDao;
import com.compasso.features.Customer.model.Customer;
import com.compasso.features.Customer.vo.CustomerVO;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.text.ParseException;

@Service
public class CustomerService {
  final CustomerDao customerDao;

  public CustomerService(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  public void createCustomer(CustomerVO customerVO) throws ParseException {
    Customer customer = customerVO.toUser();

    customerDao.createCustomer(customer);
  }

  public CustomerVO getById(Long id) {
    Customer customer = customerDao.getById(id);

    if (customer == null) {
      throw new NoResultException();
    }

    return new CustomerVO(customer);
  }

  public CustomerVO getByName(String name) {
    Customer customer = customerDao.getByName(name);

    if (customer == null) {
      throw new NoResultException();
    }

    return new CustomerVO(customer);
  }

  public void deleteById(Long id) {
    customerDao.deleteById(id);
  }

  public void updateName(Long id, String newName) {
    customerDao.updateName(id, newName);
  }
}
