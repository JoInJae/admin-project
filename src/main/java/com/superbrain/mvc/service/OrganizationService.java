package com.superbrain.mvc.service;

import com.superbrain.data.dto.OrganizationDTO;

public interface OrganizationService {
    void input(OrganizationDTO.Input param);
    void remove(String uuid);
}
