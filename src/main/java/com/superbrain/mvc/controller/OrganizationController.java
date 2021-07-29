package com.superbrain.mvc.controller;

import com.superbrain.data.dto.OrganizationDTO;
import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.service.OrganizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/organization", method = RequestMethod.POST)
@RestController public class OrganizationController extends BaseController<OrganizationDTO.Input, OrganizationDTO.Update, OrganizationService> {

    protected OrganizationController(OrganizationService service) {
        super(service);
    }

}
