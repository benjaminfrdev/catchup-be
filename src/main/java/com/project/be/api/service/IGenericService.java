package com.project.be.api.service;

import java.util.List;

public interface IGenericService<T, D> {
    List<T> getAll();

    void insert(T t);

    void insertBulk(List<T> ts);

    void delete (D d);

    T getById (Long id);

}
