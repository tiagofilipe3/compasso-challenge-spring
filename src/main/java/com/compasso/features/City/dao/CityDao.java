package com.compasso.features.City.dao;

import com.compasso.features.City.model.City;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Component
public class CityDao {
    private final EntityManager entityManager;

    public CityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public City getById(Long id) {
        return entityManager.find(City.class, id);
    }

    @Transactional
    public void createCity(City city) {
        entityManager.persist(city);
    }

    public City getByName(String name) {
        TypedQuery<City> query = entityManager.createQuery(
                "SELECT c FROM city c WHERE c.name = :name", City.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
