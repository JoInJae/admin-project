package com.superbrain.mvc.service.impl;

import com.superbrain.assist.JWT;
import com.superbrain.configuration.exception.UpdateUnavailableException;
import com.superbrain.configuration.exception.WrongEntityApproachException;
import com.superbrain.data.constant.Token;
import com.superbrain.data.domain.admin.Admin;
import com.superbrain.data.domain.universal.Organization;
import com.superbrain.data.dto.AdminDTO;
import com.superbrain.mvc.repository.AdminRepository;
import com.superbrain.mvc.repository.OrganizationRepository;
import com.superbrain.mvc.service.AdminService;
import com.superbrain.mvc.service.base.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service public class AdminServiceImpl extends BaseService<AdminRepository> implements AdminService {

    private final OrganizationRepository organizationRepository;
    private final JWT jwt;

    protected AdminServiceImpl(AdminRepository repository, OrganizationRepository organizationRepository, EntityManager em, ModelMapper mapper, JWT jwt) {
        super(repository, em, mapper);
        this.organizationRepository = organizationRepository;
        this.jwt = jwt;
    }


    @Transactional
    @Override
    public void input(AdminDTO.Input param) {

        Optional<Organization> is_organization = organizationRepository.getOrganization(param.getOrganization());

        if(is_organization.isEmpty()) throw new WrongEntityApproachException();

        Admin admin = param.toEntity(is_organization.get());

        em.persist(admin);

    }

    @Transactional
    @Override
    public void modify(String uuid, AdminDTO.Update param) {

        Optional<Admin> is_admin = repository.getAdminByUuid(uuid);

        if(is_admin.isEmpty()) throw new WrongEntityApproachException();

        Admin admin = is_admin.get();

        long check = repository.update(admin, param);

        if(check == 0 || check < 0) throw new UpdateUnavailableException();

    }

    @Transactional
    @Override
    public void remove(String uuid) {

        Optional<Admin> is_admin = repository.getAdminByUuid(uuid);

        if(is_admin.isEmpty()) throw new WrongEntityApproachException();

        em.remove(is_admin.get());

    }

    @Override
    public AdminDTO.Result get(String uuid) {

        Optional<AdminDTO.Result> is_admin_info = repository.getAdminInfoByUuid(uuid);

        if(is_admin_info.isEmpty()) throw new WrongEntityApproachException();

        return is_admin_info.get();

    }

    @Override
    public List<AdminDTO.Result> getAll() {

        return repository.getAdmins();

    }

    @Transactional
    @Override
    public AdminDTO.Token login(AdminDTO.Login param, HttpServletResponse response) {

        Optional<Admin> is_admin = repository.getAdminById(param.getId());

        if(is_admin.isEmpty()) throw new WrongEntityApproachException();

        Admin admin = is_admin.get();

        if(admin.getPassword().match(param.getPassword())) {

            String refresh = jwt.create(Token.REFRESH, admin.getUuid());

            repository.updateToken(admin, refresh);

            Cookie cookie = new Cookie("refresh", refresh);

            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setDomain("super-brain.co.kr");
            cookie.setPath("/");

            response.addCookie(cookie);

            return AdminDTO.Token.builder()
                    .access(jwt.create(Token.ACCESS, admin.getUuid()))
                    .build();

        }

        throw new WrongEntityApproachException();

    }

    @Override
    public AdminDTO.Token reissue(String refresh) {

        String uuid = jwt.get(refresh).get("uuid").toString();

        return AdminDTO.Token.builder()
                .access(jwt.create(Token.ACCESS, uuid))
                .build();

    }
}
