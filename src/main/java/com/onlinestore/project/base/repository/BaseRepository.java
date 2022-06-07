package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.BaseDomain;

import javax.persistence.QueryHint;

public interface BaseRepository<T,C> {

    C add(T t);

    C delete(T t);

    C findById(T t);
}
