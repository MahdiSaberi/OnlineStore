package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.domain.City;
import com.onlinestore.project.base.domain.User;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;
import com.onlinestore.project.base.util.ApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityRepository extends BaseRepositoryImpl<Object, City> {

    public CityRepository(EntityManagerFactory emf){super(emf);}

    public void initCity(City city){
        add(city);
    }

    public Long findByName(String name){
        ApplicationContext context = new ApplicationContext();
        String findNameQuery = "from City where name=:name";

        TypedQuery<City> query = context.getEntityManagerFactory().createEntityManager().createQuery(findNameQuery, City.class);
        query.setParameter("name",name);

        if(query.getResultList().isEmpty()){
            return null;
        }

        City city = query.getSingleResult();
        Long id = city.getId();

        return id;
    }

    public void initCity(){

    }
}