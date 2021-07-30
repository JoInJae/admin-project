package com.superbrain.mvc.service.impl;

import com.superbrain.assist.JWT;
import com.superbrain.configuration.exception.ServiceException;
import com.superbrain.configuration.exception.UpdateUnavailableException;
import com.superbrain.configuration.exception.WrongEntityApproachException;
import com.superbrain.data.constant.Response;
import com.superbrain.data.constant.Token;
import com.superbrain.data.domain.part.admin.Admin;
import com.superbrain.data.domain.part.admin.AdminAccount;
import com.superbrain.data.domain.part.univ.Organization;
import com.superbrain.data.dto.AdminDTO;
import com.superbrain.data.dto.response.BaseResponse;
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
    public BaseResponse input(AdminDTO.Input param) {

        Optional<Organization> is_organization = organizationRepository.getOrganization(param.getOrganization());

        if(is_organization.isEmpty()) throw new WrongEntityApproachException();

        Admin admin = param.toEntity(is_organization.get());

        em.persist(admin);

        return BaseResponse.success();
    }

    @Transactional
    @Override
    public BaseResponse modify(String uuid, AdminDTO.Update param) {

        Optional<AdminAccount> is_account = repository.getAdminAccount(uuid);

        if(is_account.isEmpty()) throw new WrongEntityApproachException();

        AdminAccount account = is_account.get();

        long check = repository.update(account, param);

        if(check == 0 || check < 0) throw new UpdateUnavailableException();

        return BaseResponse.success();
    }

    @Transactional
    @Override
    public BaseResponse remove(String uuid) {

        Optional<Admin> is_admin = repository.getAdmin(uuid);

        if(is_admin.isEmpty()) throw new WrongEntityApproachException();

        em.remove(is_admin.get());

        return BaseResponse.success();

    }

    @Override
    public BaseResponse get(String uuid) {

        Optional<AdminDTO.ResultDetail> is_admin_info = repository.getAdminDetail(uuid);

        if(is_admin_info.isEmpty()) throw new WrongEntityApproachException();

        return BaseResponse.success(is_admin_info.get());

    }

    @Override
    public BaseResponse getAll() {

        return BaseResponse.success(repository.getAdminList());

    }

    @Transactional
    @Override
    public AdminDTO.Token login(AdminDTO.Login param, HttpServletResponse response) {

        Optional<AdminAccount> is_admin = repository.getAdminById(param.getId());

        if(is_admin.isEmpty()) throw new ServiceException(Response.ID_NOT_AVAILABLE);

        AdminAccount admin = is_admin.get();

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

        throw new ServiceException(Response.PW_NOT_AVAILABLE);

    }

    @Override
    public AdminDTO.Token reissue(String refresh) {

        String uuid = jwt.get(refresh).get("uuid").toString();

        return AdminDTO.Token.builder()
                .access(jwt.create(Token.ACCESS, uuid))
                .build();

    }

}
