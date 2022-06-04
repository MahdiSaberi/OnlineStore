package com.onlinestore.project.base.repository.imlp;

import com.onlinestore.project.base.domain.BaseDomain;
import com.onlinestore.project.base.domain.Category;
import com.onlinestore.project.base.repository.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class BaseRepositoryImpl<T, C> implements BaseRepository<T, C> {

    private final EntityManagerFactory emf;
    private EntityManager em;

    public BaseRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public C add(T t){
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Wrong Entity!");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return null;
    }

    public C save(T t) {
        return null;
    }

    @Override
    public C delete(T id) {
        return null;
    }

    @Override
    public C find(T id) {
        return null;
    }

    //public BaseRepositoryImpl(){}
}