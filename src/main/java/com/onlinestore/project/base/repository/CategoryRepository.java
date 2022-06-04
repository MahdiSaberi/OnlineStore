package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.repository.imlp.BaseRepositoryImpl;
import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.EntityManagerFactory;

public class CategoryRepository extends BaseRepositoryImpl<Object, Category> {

    private static final Category[] categories = new Category[3];

    public CategoryRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void initCategory(){
        categories[0] = new Category("Readable");
        categories[1] = new Category("Wearable");
        categories[2] = new Category("Electrical");

        for(Category c : categories)
            add(c);
    }

}
