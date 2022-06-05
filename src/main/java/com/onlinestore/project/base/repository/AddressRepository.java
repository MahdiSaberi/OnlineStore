package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Address;
import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;

import javax.persistence.EntityManagerFactory;

public class AddressRepository extends BaseRepositoryImpl<Object, Category> {

    public AddressRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void initAddress(Address address){
        add(address);
    }

}
