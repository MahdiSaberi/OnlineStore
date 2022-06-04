package com.onlinestore.project.base.repository;

import com.onlinestore.project.base.domain.BaseDomain;

public interface BaseRepository<T,C> {

    C add(T t);

    C save(T t);

    C delete(T t);

    C find(T t);
}
