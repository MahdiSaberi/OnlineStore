package com.onlinestore.project.base.domain;

public class BaseDomain<T> {
    private T id;

    private String name;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
