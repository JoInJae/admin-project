package com.superbrain.mvc.service.impl;

import com.superbrain.mvc.repository.AdminRepository;
import com.superbrain.mvc.service.AdminService;
import com.superbrain.mvc.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service public class AdminServiceImpl extends BaseService<AdminRepository> implements AdminService {

    protected AdminServiceImpl(AdminRepository repository, EntityManager em) {
        super(repository, em);
    }


}
