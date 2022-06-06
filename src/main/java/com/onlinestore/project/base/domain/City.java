package com.onlinestore.project.base.domain;

import javax.persistence.*;
import java.util.List;

@Entity
/*@Table(name = "city",uniqueConstraints = @UniqueConstraint
        (name="city_unique",columnNames = "name"))*/
public class City extends BaseDomain{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Address> addressList;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public City(Long id){
        this.id = id;
    }

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

    public List<Address> getAddressList() {
        return addressList;
    }



    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
