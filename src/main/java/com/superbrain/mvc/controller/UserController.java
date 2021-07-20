package com.superbrain.mvc.controller;

import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/user", method = RequestMethod.POST)
@RestController public class UserController extends BaseController<UserService> {

    protected UserController(UserService service) {
        super(service);
    }

}
