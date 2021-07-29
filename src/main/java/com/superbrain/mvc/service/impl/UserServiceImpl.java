package com.superbrain.mvc.service.impl;

import com.superbrain.configuration.exception.WrongEntityApproachException;
import com.superbrain.data.domain.part.admin.Admin;
import com.superbrain.data.domain.part.user.User;
import com.superbrain.data.dto.UserDTO;
import com.superbrain.data.dto.response.BaseResponse;
import com.superbrain.mvc.repository.AdminRepository;
import com.superbrain.mvc.repository.UserRepository;
import com.superbrain.mvc.service.UserService;
import com.superbrain.mvc.service.base.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Service public class UserServiceImpl extends BaseService<UserRepository> implements UserService {

    private final AdminRepository adminRepository;

    protected UserServiceImpl(UserRepository repository, EntityManager em, ModelMapper mapper, AdminRepository adminRepository) {
        super(repository, em, mapper);
        this.adminRepository = adminRepository;
    }

    @Transactional
    @Override
    public BaseResponse input(String unique, UserDTO.Input param) {

        Optional<Admin> is_admin = adminRepository.getAdmin(unique);

        if(is_admin.isEmpty()) throw new WrongEntityApproachException();

        User user = param.toEntity(is_admin.get());

        em.persist(user);

        return BaseResponse.success();

    }

    @Override
    public BaseResponse modify(String uuid, UserDTO.Update param) {
        return null;
    }

    @Override
    public BaseResponse remove(String uuid) {
        return null;
    }

    @Override
    public BaseResponse get(String uuid) {

        Optional<UserDTO.ResultDetail> is_detail = repository.getUserDetail(uuid);

        return null;
    }

    @Override
    public BaseResponse getAll() {

        return BaseResponse.success(repository.getUserList());

    }
}
