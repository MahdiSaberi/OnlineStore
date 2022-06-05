package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Cart;
import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.domain.Product;
import com.onlinestore.project.base.domain.User;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;

import javax.persistence.EntityManagerFactory;

public class CartRepository extends BaseRepositoryImpl<Object, Category> {

    public CartRepository(EntityManagerFactory emf){super(emf);}

    public void initCart(Cart cart){
        add(cart);
    }

    public void addProduct(Product product, User user){

    }

    public void removeProduct(Product product, User user){}

    public void settle(Product product, User user){}
}
