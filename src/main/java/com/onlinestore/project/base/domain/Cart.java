package com.onlinestore.project.base.domain;

import java.util.Set;

public class Cart <ID extends BaseDomain> extends BaseDomain{

    private ID id;

    private Set<Product> productSet;

    public Cart() {
    }

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
