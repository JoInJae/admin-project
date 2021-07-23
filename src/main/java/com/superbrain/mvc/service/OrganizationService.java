package com.superbrain.mvc.service;

import com.superbrain.data.dto.OrganizationDTO;

import java.util.List;

public interface OrganizationService {
    void input(OrganizationDTO.Input param);
    void update(String uuid, OrganizationDTO.Update param);
    void remove(String uuid);
    OrganizationDTO.Result getOrganization(String uuid);
    List<OrganizationDTO.Result> getOrganizations();
}
