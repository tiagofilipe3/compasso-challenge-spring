package com.compasso.features.Customer.dao;

import com.compasso.features.Customer.model.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Component
public class CustomerDao {
  private final EntityManager entityManager;

  public CustomerDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Transactional
  public Customer getById(Long id) {
    return entityManager.find(Customer.class, id);
  }

  @Transactional
  public void createCustomer(Customer Customer) {
    entityManager.persist(Customer);
  }

  @Transactional
  public Customer getByName(String name) {
    TypedQuery<Customer> query = entityManager.createQuery(
            "SELECT c FROM Customer c WHERE c.name = :name", Customer.class);
    query.setParameter("name", name);
    return query.getSingleResult();
  }
}
