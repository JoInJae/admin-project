package com.superbrain.mvc.service.base;

import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;

public abstract class BaseService <R>{

    protected final R repository;
    protected final EntityManager em;
    protected final ModelMapper mapper;

    protected BaseService(R repository, EntityManager em, ModelMapper mapper) {
        this.repository = repository;
        this.em = em;
        this.mapper = mapper;
    }



}
