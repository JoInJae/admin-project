package com.superbrain.mvc.controller;

import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/admin", method = RequestMethod.POST)
@RestController public class AdminController extends BaseController<AdminService> {

    protected AdminController(AdminService service) {
        super(service);
    }

}
