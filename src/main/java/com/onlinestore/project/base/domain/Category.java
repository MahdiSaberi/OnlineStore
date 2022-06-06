package com.onlinestore.project.base.domain;

import javax.persistence.*;
import java.util.List;
@Entity
public class Category extends BaseDomain<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
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

    public List<Product> getProducts() {
        return products;
    }



    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
