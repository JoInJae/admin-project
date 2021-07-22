package com.superbrain.mvc.service.impl;

import com.superbrain.data.domain.universal.Organization;
import com.superbrain.data.dto.OrganizationDTO;
import com.superbrain.mvc.repository.OrganizationRepository;
import com.superbrain.mvc.service.OrganizationService;
import com.superbrain.mvc.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service public class OrganizationServiceImpl extends BaseService<OrganizationRepository>implements OrganizationService {

    protected OrganizationServiceImpl(OrganizationRepository repository, EntityManager em) {
        super(repository, em);
    }

    @Transactional
    @Override
    public void input(OrganizationDTO.Input param) {

        em.persist(param.toEntity());

    }

    @Override
    public void remove(String uuid) {

    }
}
