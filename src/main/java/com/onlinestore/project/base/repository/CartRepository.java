package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Cart;
import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;

import javax.persistence.EntityManagerFactory;

public class CartRepository extends BaseRepositoryImpl<Object, Category> {

    public CartRepository(EntityManagerFactory emf){super(emf);}

    public void initCart(Cart cart){
        add(cart);
    }
}
