package com.onlinestore.project.base.util;

import com.onlinestore.project.base.repository.CategoryRepository;
import com.onlinestore.project.base.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

public class ApplicationContext {
    public static EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();

    private CategoryRepository categoryRepository = null;
    private ProductRepository productRepository = null;

    private Scanner intScanner = null;
    private Scanner stringScanner = null;

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public CategoryRepository getCategoryRepository() {
        if(categoryRepository == null)
            this.categoryRepository = new CategoryRepository(emf);

        return categoryRepository;
    }

    public ProductRepository getProductRepository() {
        if(productRepository == null)
            this.productRepository = new ProductRepository(emf);

        return productRepository;
    }

    public Scanner getIntScanner() {
        if (intScanner == null)
            this.intScanner = new Scanner(System.in);
        return intScanner;
    }

    public Scanner getStringScanner() {
        if (stringScanner == null)
            this.stringScanner = new Scanner(System.in);
        return stringScanner;
    }
}
