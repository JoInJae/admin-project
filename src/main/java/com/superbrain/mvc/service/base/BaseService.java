package com.superbrain.mvc.service.base;

import javax.persistence.EntityManager;

public abstract class BaseService <R>{

    protected final R repository;
    protected final EntityManager em;

    protected BaseService(R repository, EntityManager em) {
        this.repository = repository;
        this.em = em;
    }

}
