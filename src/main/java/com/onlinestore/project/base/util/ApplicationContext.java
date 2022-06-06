package com.onlinestore.project.base.util;

import com.onlinestore.project.base.repository.*;

import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

public class ApplicationContext {

    public static EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();

    private CategoryRepository categoryRepository = null;
    private ProductRepository productRepository = null;
    private UserRepository userRepository = null;
    private AddressRepository addressRepository = null;
    private CityRepository cityRepository = null;
    private CartRepository cartRepository = null;

    private Scanner intScanner = null;
    private Scanner stringScanner = null;

    public static void setEmf(EntityManagerFactory emf) {
        ApplicationContext.emf = emf;
    }

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

    public UserRepository getUserRepository() {
        if(userRepository == null)
            this.userRepository = new UserRepository(emf);

        return userRepository;
    }

    public AddressRepository getAddressRepository() {
        if(addressRepository == null)
            this.addressRepository = new AddressRepository(emf);

        return addressRepository;
    }

    public CityRepository getCityRepository(){
        if(cityRepository == null)
            this.cityRepository = new CityRepository(emf);

        return cityRepository;
    }

    public CartRepository getCartRepository(){
        if(cartRepository == null)
            this.cartRepository = new CartRepository(emf);

        return cartRepository;
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
