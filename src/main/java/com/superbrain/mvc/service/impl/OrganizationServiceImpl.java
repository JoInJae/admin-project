package com.superbrain.mvc.service.impl;

import com.superbrain.configuration.exception.UpdateUnavailableException;
import com.superbrain.configuration.exception.WrongEntityApproachException;
import com.superbrain.data.domain.universal.Organization;
import com.superbrain.data.dto.OrganizationDTO;
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
    public void input(OrganizationDTO.Input param) {

        em.persist(param.toEntity());

    }

    @Transactional
    @Override
    public void update(String uuid, OrganizationDTO.Update param) {

        Optional<Organization> is_organization = repository.getOrganizationByUuid(uuid);

        if(is_organization.isEmpty()) throw new WrongEntityApproachException();

        Organization organization = is_organization.get();

        long check = repository.update(organization, param);

        if(check == 0 || check < 0) throw new UpdateUnavailableException();

    }

    @Transactional
    @Override
    public void remove(String uuid) {

        Optional<Organization> is_organization = repository.getOrganizationByUuid(uuid);

        if(is_organization.isEmpty()) throw new WrongEntityApproachException();

        repository.remove(is_organization.get());

    }

    @Override
    public OrganizationDTO.Result getOrganization(String uuid) {

        Optional<Organization> is_organization = repository.getOrganizationByUuid(uuid);

        if(is_organization.isEmpty()) throw new WrongEntityApproachException();

        return mapper.map(is_organization.get(), OrganizationDTO.Result.class);

    }

    @Override
    public List<OrganizationDTO.Result> getOrganizations() {
        return repository.getOrganizations();
    }

}
