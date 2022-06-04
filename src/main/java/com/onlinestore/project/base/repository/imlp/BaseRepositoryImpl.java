package com.onlinestore.project.base.repository.imlp;

import com.onlinestore.project.base.domain.BaseDomain;
import com.onlinestore.project.base.repository.BaseRepository;

public abstract class BaseRepositoryImpl<ID, T extends BaseDomain<ID>> implements BaseRepository<ID, T> {
    @Override
    public T save(T id) {
        return null;
    }

    @Override
    public T delete(T id) {
        return null;
    }

    @Override
    public T find(T id) {
        return null;
    }
}
