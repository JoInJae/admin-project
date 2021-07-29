package com.superbrain.mvc.controller.base;

import com.superbrain.data.dto.response.BaseResponse;
import com.superbrain.mvc.service.base.Service;
import org.springframework.http.ResponseEntity;

public class BaseController<Input, Update, S extends Service<Input, Update>> implements Controller<Input, Update>{

    protected final S service;

    protected BaseController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<BaseResponse> input(String unique, Input param) {return ResponseEntity.ok(service.input(param));}

    @Override
    public ResponseEntity<BaseResponse> modify(String unique, String uuid, Update param) {return ResponseEntity.ok(service.modify(uuid, param));}

    @Override
    public ResponseEntity<BaseResponse> remove(String unique, String uuid) {return ResponseEntity.ok(service.remove(uuid));}

    @Override
    public ResponseEntity<BaseResponse> get(String unique, String uuid) {
        return ResponseEntity.ok(service.get(uuid));
    }

    @Override
    public ResponseEntity<BaseResponse> getAll(String unique) {
        return ResponseEntity.ok(service.getAll());
    }

}
