package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Product;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;
import com.onlinestore.project.base.util.ApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ProductRepository extends BaseRepositoryImpl<Object, Product> {

    ApplicationContext context = new ApplicationContext();

    private static final Product[] products = new Product[10];

    public ProductRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void initProduct(){
        products[0] = new Product("Shoes","Sport",50L,100);
        products[1] = new Product("Shoes","Formal",60L,100);

        products[2] = new Product("Radio","Samsung",180L,100);
        products[3] = new Product("Radio","Pioneer",150L,100);

        products[4] = new Product("Television","LG",300L,100);
        products[5] = new Product("Television","X-VISION",250L,100);

        products[6] = new Product("Magazine","Science",10L,100);
        products[7] = new Product("Magazine","Political",15L,100);

        products[8] = new Product("Book","Novel",20L,100);
        products[9] = new Product("Book","History",25L,100);

        for(Product p : products)
            add(p);
    }

    public void printProducts(){
        String findProductsQuery = "select new Product(id,name,model,price,quantity) from Product";
        TypedQuery<Product> query = context.getEntityManagerFactory().createEntityManager().createQuery(findProductsQuery, Product.class);
        ArrayList<Product> entries = (ArrayList<Product>) query.getResultList();

        for(Product e : entries){
            System.out.println("=================================");
            System.out.print(e.getId()+". ");
            System.out.println(e.getName()+"\tTitle: "+e.getModel()+"\nQuantity: "+e.getQuantity()+"\tPrice: "+e.getPrice());
        }
        System.out.println("=================================");
    }

}
