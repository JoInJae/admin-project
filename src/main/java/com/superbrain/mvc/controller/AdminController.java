package com.superbrain.mvc.controller;

import com.superbrain.data.dto.AdminDTO;
import com.superbrain.data.dto.response.BaseResponse;
import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.controller.base.BaseControllerImpl;
import com.superbrain.mvc.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(path = "/admin", method = RequestMethod.POST)
@RestController public class AdminController extends BaseController<AdminService> implements BaseControllerImpl<AdminDTO.Input, AdminDTO.Update> {

    protected AdminController(AdminService service) {
        super(service);
    }

    @Override
    public ResponseEntity<BaseResponse> input(AdminDTO.Input param) {

        service.input(param);

        return ResponseEntity.ok(BaseResponse.success());

    }

    @Override
    public ResponseEntity<BaseResponse> modify(String uuid, AdminDTO.Update param) {

        service.modify(uuid, param);

        return ResponseEntity.ok(BaseResponse.success());

    }

    @Override
    public ResponseEntity<BaseResponse> remove(String uuid) {

        service.remove(uuid);

        return ResponseEntity.ok(BaseResponse.success());
    }

    @Override
    public ResponseEntity<BaseResponse> get(String uuid) {

        return ResponseEntity.ok(BaseResponse.success(service.get(uuid)));

    }

    @Override
    public ResponseEntity<BaseResponse> getAll() {

        return ResponseEntity.ok(BaseResponse.success(service.getAll()));

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
