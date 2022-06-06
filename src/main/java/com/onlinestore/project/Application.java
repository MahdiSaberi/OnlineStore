package com.onlinestore.project;

import com.onlinestore.project.base.domain.User;
import com.onlinestore.project.base.repository.CategoryRepository;
import com.onlinestore.project.base.repository.ProductRepository;
import com.onlinestore.project.base.util.ApplicationContext;
import com.onlinestore.project.base.util.HibernateUtil;
import com.onlinestore.project.base.util.Menu;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        context.getEntityManagerFactory().createEntityManager();
        //context.getProductRepository().initProduct();
        Menu menu = new Menu();
        menu.firstMenu();
        //menu.loginMenu();
        System.out.println("DONE!");
    }
}