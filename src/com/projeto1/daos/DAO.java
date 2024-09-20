package com.projeto1.daos;

import java.util.List;

public interface DAO<T> {
    public abstract void save(T model);
    public abstract List<T> findAll();
    public abstract T findById(Integer id);
    public abstract void update(T model);
    public abstract void delete(Integer id);
}
