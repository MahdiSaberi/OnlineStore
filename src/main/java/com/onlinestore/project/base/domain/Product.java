package com.onlinestore.project.base.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Product extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pro_gen")
    @SequenceGenerator(name = "pro_gen",sequenceName = "pro_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String model;

    @Column
    private Long price;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany
    //@JoinColumn(name = "cart_id")
    private List<Cart> cart;

    public Product() {
    }

    public Product(String name, String model, Long price, Integer quantity) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(Long id,String name, String model, Long price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
