package com.onlinestore.project.base.util;

import com.onlinestore.project.base.domain.Address;
import com.onlinestore.project.base.domain.Product;
import com.onlinestore.project.base.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;


public class Menu {
    ApplicationContext context = new ApplicationContext();

    //First Menu

    public void firstMenu(){
        System.out.println("Welcome to Online Store\n1.Login\n2.Register\n3.Products\n4.Exit");
        int select = context.getIntScanner().nextInt();

        switch (select){
            case 1:
                loginMenu();
                break;

            case 2:
                registerMenu();
                break;

            case 3:
                productMenu();
                break;

            case 4:
                System.exit(0);
        }
    }

    public void loginMenu() {
        System.out.println("Username:");
        String username = context.getStringScanner().nextLine();

        System.out.println("Password:");
        String password = context.getStringScanner().nextLine();

        String findUserAndPassQuery = "from User where username=:username and password=:password";

        TypedQuery<User> query = context.getEntityManagerFactory().createEntityManager().createQuery(findUserAndPassQuery, User.class);

        query.setParameter("username",username);
        query.setParameter("password",password);

        while (true){
            try {
                User user = query.getSingleResult();
                System.out.println("You Login Successfully!");
                userMenu(user);
                break;
            }catch (Exception e){
                System.out.println("Wrong Username or Password!");
                loginMenu();
            }
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

        System.out.println("You Registered Successfully!");
        System.out.println("Welcome, "+user.getFirstName());
        userMenu(user);
    }

    public void productMenu() {
        System.out.println("List of Products:");
        String findProductsQuery = "select new Product(name,model,price,quantity) from Product";
        TypedQuery<Product> query = context.getEntityManagerFactory().createEntityManager().createQuery(findProductsQuery, Product.class);
        ArrayList<Product> entries = (ArrayList<Product>) query.getResultList();
        for(Product e : entries){
            System.out.println("=================================");
            System.out.println(e.getName()+"\tTitle: "+e.getModel()+"\nQuantity: "+e.getQuantity()+"\tPrice: "+e.getPrice());
        }
        System.out.println("=================================");


    }
    //End First Menu
    //User Menu
    public void userMenu(User user){
        System.out.println("1.Products(See & Buy)\n2.Your Cart\n3.Logout");
        int select = context.getIntScanner().nextInt();

        switch (select){
            case 1:
                userProductMenu(user);
                break;

            case 2:
                userCartMenu(user);
                break;

            case 3:
                firstMenu();
                break;
        }

    }

    public void userProductMenu(User user){
        productMenu();
        System.out.println("1.Add\n2.Remove\n3.Settle\n4.See Cart\n5.Back");
    }

    public void userCartMenu(User user){
        System.out.println(user.getFirstName()+"'s Cart Status:");

    }

    //End User Menu
    //
}
