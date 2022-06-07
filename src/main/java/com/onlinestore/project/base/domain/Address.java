package com.onlinestore.project.base.domain;

import javax.persistence.*;

@Entity
public class Address extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_gen")
    @SequenceGenerator(name = "address_gen",sequenceName = "address_seq")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "postal_code")
    private String postalCode;


    @ManyToOne
    @JoinColumn(name = "c_id")
    private City city;

    public Address() {
    }

    public Address(String street, String postalCode, City city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
