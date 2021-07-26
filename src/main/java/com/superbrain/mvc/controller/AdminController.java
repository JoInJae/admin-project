package com.superbrain.mvc.controller;

import com.superbrain.data.dto.AdminDTO;
import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.controller.base.BaseControllerImpl;
import com.superbrain.mvc.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/admin", method = RequestMethod.POST)
@RestController public class AdminController extends BaseController<AdminService> implements BaseControllerImpl<AdminDTO.Input, AdminDTO.Update, AdminDTO.Result> {

    protected AdminController(AdminService service) {
        super(service);
    }

    @Override
    public void input(AdminDTO.Input param) {
        service.input(param);
    }

    @Override
    public void modify(String uuid, AdminDTO.Update param) {
        service.modify(uuid, param);
    }

    @Override
    public void remove(String uuid) {
        service.remove(uuid);
    }

    @Override
    public ResponseEntity<AdminDTO.Result> get(String uuid) {
        return ResponseEntity.ok(service.get(uuid));
    }

    @Override
    public ResponseEntity<List<AdminDTO.Result>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
