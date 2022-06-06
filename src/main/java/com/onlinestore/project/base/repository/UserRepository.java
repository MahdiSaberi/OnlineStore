package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.domain.User;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;

import javax.persistence.EntityManagerFactory;

public class UserRepository extends BaseRepositoryImpl<Object, User> {

    private User user;

    public UserRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void initUser(User user){
        add(user);
    }

}
