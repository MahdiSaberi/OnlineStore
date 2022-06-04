package com.onlinestore.project.base.domain;

import java.util.List;

public class Category<ID extends BaseDomain> extends BaseDomain {

    private ID id;

    private String name;

    private List<Product> products;

    public Category() {
    }

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
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
