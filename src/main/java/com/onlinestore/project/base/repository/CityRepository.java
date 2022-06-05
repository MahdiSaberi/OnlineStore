package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.domain.City;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;

import javax.persistence.EntityManagerFactory;

public class CityRepository extends BaseRepositoryImpl<Object, Category> {

    public CityRepository(EntityManagerFactory emf){super(emf);}

    public void initCity(City city){
        add(city);
    }
}
