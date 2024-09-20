package com.projeto1.services;

import com.projeto1.daos.DAO;

public abstract class Service<T> {

    private DAO<T> dao;

    public abstract void readFormAndSave();

    public abstract void findAllAndShow();

    public abstract void findByIdAndShow();

    public abstract void updateIfConfirmed();

    public abstract void deleteIfConfirmed();

    public DAO<T> getDao() {
        return dao;
    }

    public void setDao(DAO<T> dao) {
        this.dao = dao;
    }
}
