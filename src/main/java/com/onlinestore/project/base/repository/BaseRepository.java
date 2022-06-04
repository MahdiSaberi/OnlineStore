package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.BaseDomain;

public interface BaseRepository<ID, T extends BaseDomain<ID>> {
    T save(T t);

    T delete(T t);

    T find(T t);
}
