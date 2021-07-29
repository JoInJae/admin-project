package com.superbrain.mvc.controller;

import com.superbrain.data.dto.UserDTO;
import com.superbrain.data.dto.response.BaseResponse;
import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/user", method = RequestMethod.POST)
@RestController public class UserController extends BaseController<UserDTO.Input, UserDTO.Update, UserService> {

    protected UserController(UserService service) {
        super(service);
    }

    @Override
    public ResponseEntity<BaseResponse> input(String unique, UserDTO.Input param) {
        return ResponseEntity.ok(service.input(unique, param));
    }
}
