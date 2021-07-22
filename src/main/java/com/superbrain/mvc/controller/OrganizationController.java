package com.superbrain.mvc.controller;

import com.superbrain.data.dto.OrganizationDTO;
import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.controller.base.BaseControllerImpl;
import com.superbrain.mvc.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/organization", method = RequestMethod.POST)
@RestController public class OrganizationController extends BaseController<OrganizationService>
        implements BaseControllerImpl<OrganizationDTO.Input, OrganizationDTO.Update, OrganizationDTO.Result> {

    protected OrganizationController(OrganizationService service) {
        super(service);
    }

    @Override
    public void input(OrganizationDTO.Input param) {
        service.input(param);
    }

    @Override
    public void modify(OrganizationDTO.Update param) {

    }

    @Override
    public void remove(String uuid) {
        service.remove(uuid);
    }

    @Override
    public ResponseEntity<OrganizationDTO.Result> get(String uuid) {
        return null;
    }

    @Override
    public ResponseEntity<List<OrganizationDTO.Result>> getAll() {
        return null;
    }
}
