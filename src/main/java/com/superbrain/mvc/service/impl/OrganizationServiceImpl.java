package com.superbrain.mvc.service.impl;

import com.superbrain.configuration.exception.UpdateUnavailableException;
import com.superbrain.configuration.exception.WrongEntityApproachException;
import com.superbrain.data.domain.part.univ.Organization;
import com.superbrain.data.dto.OrganizationDTO;
import com.superbrain.data.dto.response.BaseResponse;
import com.superbrain.mvc.repository.OrganizationRepository;
import com.superbrain.mvc.service.OrganizationService;
import com.superbrain.mvc.service.base.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service public class OrganizationServiceImpl extends BaseService<OrganizationRepository>implements OrganizationService {

    protected OrganizationServiceImpl(OrganizationRepository repository, EntityManager em, ModelMapper mapper) {
        super(repository, em, mapper);
    }

    @Transactional
    @Override
    public BaseResponse input(OrganizationDTO.Input param) {

        em.persist(param.toEntity());

        return BaseResponse.success();

    }

    @Transactional
    @Override
    public BaseResponse modify(String uuid, OrganizationDTO.Update param) {

        Optional<Organization> is_organization = repository.getOrganization(uuid);

        if(is_organization.isEmpty()) throw new WrongEntityApproachException();

        Organization organization = is_organization.get();

        long check = repository.update(organization, param);

        if(check == 0 || check < 0) throw new UpdateUnavailableException();

        return BaseResponse.success();

    }

    @Transactional
    @Override
    public BaseResponse remove(String uuid) {

        Optional<Organization> is_organization = repository.getOrganization(uuid);

        if(is_organization.isEmpty()) throw new WrongEntityApproachException();

        repository.remove(is_organization.get());

        return BaseResponse.success();

    }

    @Override
    public BaseResponse get(String uuid) {

        Optional<OrganizationDTO.DetailResult> is_organization_detail = repository.getOrganizationDetail(uuid);

        if(is_organization_detail.isEmpty()) throw new WrongEntityApproachException();

        return BaseResponse.success(is_organization_detail.get());

    }

    @Override
    public BaseResponse getAll() {

        List<OrganizationDTO.Result> results = repository.getOrganizations();

        return BaseResponse.success(results);

    }

}
