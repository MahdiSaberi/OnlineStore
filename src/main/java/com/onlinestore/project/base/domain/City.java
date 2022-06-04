package com.onlinestore.project.base.domain;

import java.util.List;

public class City <ID extends BaseDomain> extends BaseDomain{

    private ID id;

    private String name;

    private List<Address> addressList;

    public City() {
    }

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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
