package com.superbrain.mvc.controller;

import com.superbrain.data.dto.OrganizationDTO;
import com.superbrain.mvc.controller.base.ControllerImpl;
import com.superbrain.mvc.service.OrganizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/organization", method = RequestMethod.POST)
@RestController public class OrganizationController extends ControllerImpl<OrganizationDTO.Input, OrganizationDTO.Update, OrganizationService> {

    public OrganizationController(OrganizationService service) {
        super(service);
    }

/*
    @Override
    public ResponseEntity<BaseResponse> input(OrganizationDTO.Input param) {

        service.input(param);

        return ResponseEntity.ok(BaseResponse.success());
    }

    @Override
    public ResponseEntity<BaseResponse> modify(String uuid, OrganizationDTO.Update param) {

        service.update(uuid, param);

        return ResponseEntity.ok(BaseResponse.success());

    }

    @Override
    public ResponseEntity<BaseResponse> remove(String uuid) {

        service.remove(uuid);

        return ResponseEntity.ok(BaseResponse.success());

    }

    @Override
    public ResponseEntity<BaseResponse> get(String uuid) {

        return ResponseEntity.ok(BaseResponse.success(service.getOrganization(uuid)));

    }

    @Override
    public ResponseEntity<BaseResponse> getAll() {

        return ResponseEntity.ok(BaseResponse.success(service.getOrganizations()));

    }

 */
}
