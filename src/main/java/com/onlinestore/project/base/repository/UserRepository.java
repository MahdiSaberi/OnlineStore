package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.domain.Product;
import com.onlinestore.project.base.domain.User;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;
import com.onlinestore.project.base.util.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserRepository extends BaseRepositoryImpl<Object, User> {
    ApplicationContext context = new ApplicationContext();
    private User user;

    public UserRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void initUser(User user){
        add(user);
    }

    public User findById(Long id) {
        EntityManagerFactory emf = context.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User u = em.find(User.class,id);
        em.getTransaction().commit();
        return u;
    }

}
