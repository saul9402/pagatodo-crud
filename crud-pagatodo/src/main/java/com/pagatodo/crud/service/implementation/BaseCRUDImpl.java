package com.pagatodo.crud.service.implementation;

import com.pagatodo.crud.exception.types.RegisterNotFoundException;
import com.pagatodo.crud.persistence.repository.BaseRepository;
import com.pagatodo.crud.service.definition.BaseCRUD;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseCRUDImpl<T, ID> implements BaseCRUD<T, ID> {

    protected abstract BaseRepository<T, ID> getRepositoryBean();

    @Override
    @Transactional
    public T save(T t) {
        return getRepositoryBean().save(t);
    }

    @Override
    public T update(ID id, T t) {
        getRepositoryBean().findById(id).orElseThrow(() -> new RegisterNotFoundException("No se encontró el elemento con id: " + id));
        return getRepositoryBean().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepositoryBean().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepositoryBean().findById(id).orElseThrow(() -> new RegisterNotFoundException("No se encontró el elemento con id: " + id));
    }

    @Override
    public void delete(ID id) {
        getRepositoryBean().findById(id).orElseThrow(() -> new RegisterNotFoundException("No se encontró el elemento con id: " + id));
        getRepositoryBean().deleteById(id);
    }
}
