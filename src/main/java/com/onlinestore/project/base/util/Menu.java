package com.onlinestore.project.base.util;

import com.onlinestore.project.base.domain.Address;
import com.onlinestore.project.base.domain.User;

import javax.persistence.TypedQuery;


public class Menu {
    ApplicationContext context = new ApplicationContext();

    //First Menu
    public void loginMenu() {
        System.out.println("Username:");
        String username = context.getStringScanner().nextLine();

        System.out.println("Password:");
        String password = context.getStringScanner().nextLine();

        String findUserAndPassQuery = "from User where username=:username and password=:password";

        TypedQuery<User> query = context.getEntityManagerFactory().createEntityManager().createQuery(findUserAndPassQuery, User.class);

        query.setParameter("username",username);
        query.setParameter("password",password);

        try {
            User user = query.getSingleResult();
            System.out.println("You Login Successfully!");
        }catch (Exception e){
            System.out.println("Wrong Username or Password!");
        }

    }

    public void registerMenu() {
        System.out.println("Firstname:");
        String firstName = context.getStringScanner().nextLine();

        System.out.println("Lastname:");
        String lastName = context.getStringScanner().nextLine();

        System.out.println("Username:");
        String userame = context.getStringScanner().nextLine();

        System.out.println("Password:");
        String password = context.getStringScanner().nextLine();

        System.out.println("City:");
        String city = context.getStringScanner().nextLine();

        System.out.println("Street:");
        String street = context.getStringScanner().nextLine();

        System.out.println("Postal Code:");
        String postalCode = context.getStringScanner().nextLine();

        System.out.println("Email:");
        String email = context.getStringScanner().nextLine();

        User user = new User(firstName,lastName,userame,password);

        //user.setAddress(new Address(street,postalCode));
        user.setEmail(email);
        context.getUserRepository().initUser(user);
    }

    public void productMenu() {
    }
    //End First Menu
    //User Menu
    public void userProductMenu(){}

    public void userCartMenu(){}

    //End User Menu
    //
}
