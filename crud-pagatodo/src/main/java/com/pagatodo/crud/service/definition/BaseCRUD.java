package com.pagatodo.crud.service.definition;

import java.util.List;

public interface BaseCRUD<T, ID> {

    T save(T t);

    T update(ID id, T t);

    List<T> findAll();

    T findById(ID id);

    void delete(ID id);


}
