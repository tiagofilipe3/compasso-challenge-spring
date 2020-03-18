package com.compasso.features.City.dao;

import com.compasso.features.City.model.City;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CityDao {
    private final EntityManager entityManager;

    public CityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public City getById(Long id) {
        return entityManager.find(City.class, id);
    }

    @Transactional
    public void createCity(City city) {
        entityManager.persist(city);
    }

    @Transactional
    public City getByName(String name) {
        TypedQuery<City> query = entityManager.createQuery(
                "SELECT c FROM City c WHERE c.name = :name", City.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Transactional
    public List<City> getByState(String state) {
        TypedQuery<City> query = entityManager.createQuery(
                "SELECT c FROM City c WHERE c.state = :state", City.class);
        query.setParameter("state", state);
        return query.getResultList();
    }
}
