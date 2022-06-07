package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Cart;
import com.onlinestore.project.base.domain.Product;
import com.onlinestore.project.base.domain.User;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;
import com.onlinestore.project.base.util.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.util.List;

public class CartRepository extends BaseRepositoryImpl<Object, Cart> {

    ApplicationContext context = new ApplicationContext();

    public CartRepository(EntityManagerFactory emf){super(emf);}

    public void initCart(Cart cart){
        add(cart);
    }

    public void addProduct(User user){
        Long productId = context.getIntScanner().nextLong();
        EntityManager em = context.getEntityManagerFactory().createEntityManager();
        Long userId = user.getId();
        Cart cart = new Cart();

        User u = em.find(User.class,userId);
        Product p = em.find(Product.class,productId);

        String firstTimeProduct = "from Cart where user=:user and product=:product";
        TypedQuery<Cart> query = context.getEntityManagerFactory().createEntityManager().createQuery(firstTimeProduct, Cart.class);
        query.setParameter("user",u);
        query.setParameter("product",p);
        List<Cart> cartList = query.getResultList();

        if(cartList == null || cartList.isEmpty()){
            System.out.println("its null");
            cart.setProduct(p);
            cart.setUser(u);
            cart.setQuantity(1);
            context.getCartRepository().initCart(cart);
        }
        else{
            for(Cart c : cartList){
                if(c.getProduct().getName().equals(p.getName()) && c.getUser().getUsername().equals(u.getUsername())){

                    try {
                        em.getTransaction().begin();
                        Cart oldCart = em.find(Cart.class,c.getId());
                        em.remove(oldCart);
                        em.getTransaction().commit();
                    }catch (Exception e){
                        System.out.println("Wrong Entity!");
                    }

                    Cart newC = new Cart();
                    newC.setProduct(p);
                    newC.setQuantity(c.getQuantity()+1);
                    newC.setUser(u);
                    initCart(newC);
                    break;
                }
            }
        }

        if(p.getQuantity() != 0 && p.getQuantity() != null){
            p.setQuantity(p.getQuantity()-1);
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }

        System.out.println("Added!");
    }

    public void removeProduct(User user){
        Long productId = context.getIntScanner().nextLong();
        EntityManager em = context.getEntityManagerFactory().createEntityManager();
        Long userId = user.getId();

        User u = em.find(User.class,userId);
        Product p = em.find(Product.class,productId);

        String firstTimeProduct = "from Cart where user=:user and product=:product";
        TypedQuery<Cart> query = context.getEntityManagerFactory().createEntityManager().createQuery(firstTimeProduct, Cart.class);
        query.setParameter("user",u);
        query.setParameter("product",p);
        List<Cart> cartList = query.getResultList();

            for(Cart c : cartList){
                if(c.getProduct().getName().equals(p.getName()) && c.getUser().getUsername().equals(u.getUsername())){
                    System.out.println("Yes!");
                    try {
                        em.getTransaction().begin();
                        Cart oldCart = em.find(Cart.class,c.getId());
                        em.remove(oldCart);
                        em.getTransaction().commit();
                        System.out.println("Removed!");
                    }catch (Exception e){
                        System.out.println("Wrong Entity!");
                    }

                    if(c.getQuantity() != 1){
                    Cart newC = new Cart();
                    newC.setProduct(p);
                    newC.setQuantity(c.getQuantity()-1);
                    newC.setUser(u);
                    initCart(newC);
                    System.out.println("Removed!");
                    break;
                    }

                }
            }

        if(p.getQuantity() != null){
            p.setQuantity(p.getQuantity()+1);
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }
    }

    public void settle(User user){
        //Long productId = context.getIntScanner().nextLong();
        EntityManager em = context.getEntityManagerFactory().createEntityManager();
        Long userId = user.getId();

        User u = em.find(User.class,userId);

        String userProduct = "from Cart where user=:user";
        TypedQuery<Cart> query = context.getEntityManagerFactory().createEntityManager().createQuery(userProduct, Cart.class);
        query.setParameter("user",u);
        List<Cart> cartList = query.getResultList();

        for(Cart c : cartList){
            Cart removedCart = em.find(Cart.class,c.getId());
            em.getTransaction().begin();
            em.remove(removedCart);
            em.getTransaction().commit();
        }

    }

    public void printCart(User user){
        String findProductsInCartQuery = "from Cart where user=:user";
        TypedQuery<Cart> query = context.getEntityManagerFactory().createEntityManager().createQuery(findProductsInCartQuery, Cart.class);
        query.setParameter("user",user);

        List<Cart> cart = query.getResultList();
        Long totalPrice = 0L;
        for(Cart c : cart){
            System.out.println("============================");
            System.out.print(c.getProduct().getName());
            System.out.println("\tQuantity: "+c.getQuantity()+"\tPrice: "+c.getProduct().getPrice());
            totalPrice = totalPrice + c.getProduct().getPrice()*c.getQuantity();
        }
        System.out.println("Total Price: "+totalPrice);
        System.out.println("============================");
    }

}