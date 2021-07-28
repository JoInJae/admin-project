package com.superbrain.mvc.controller;

import com.superbrain.data.dto.AdminDTO;
import com.superbrain.data.dto.response.BaseResponse;
import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.controller.base.BaseControllerImpl;
import com.superbrain.mvc.controller.base.ControllerImpl;
import com.superbrain.mvc.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(path = "/admin", method = RequestMethod.POST)
@RestController public class AdminController extends ControllerImpl<AdminDTO.Input, AdminDTO.Update, AdminService> {

    protected AdminController(AdminService service) {
        super(service);
    }


    @RequestMapping(path="/login", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> login(@RequestBody AdminDTO.Login param, HttpServletResponse response) {

        return ResponseEntity.ok(BaseResponse.success(service.login(param, response)));

    }

    @RequestMapping(path="/reissue", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> reissue(@CookieValue(value="refresh") Cookie cookie) {

        return ResponseEntity.ok(BaseResponse.success(service.reissue(cookie.getValue())));

    }

}
