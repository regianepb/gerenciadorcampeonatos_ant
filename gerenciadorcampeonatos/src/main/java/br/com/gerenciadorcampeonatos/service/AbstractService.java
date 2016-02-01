package br.com.gerenciadorcampeonatos.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractService<T> {

    @PersistenceContext
    protected EntityManager manager;

    public void persist(T t) {
        manager.persist(t);
    }

    public T merge(T t) {
        return manager.merge(t);
    }

    public void remove(T t) {
        manager.remove(t);
    }
    
}
