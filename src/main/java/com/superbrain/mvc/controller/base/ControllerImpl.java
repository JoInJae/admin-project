package com.superbrain.mvc.controller.base;

import com.superbrain.data.dto.response.BaseResponse;
import com.superbrain.mvc.service.base.Service;
import org.springframework.http.ResponseEntity;

public class ControllerImpl<Input, Update, S extends Service<Input, Update>> implements Controller<Input, Update>{

    protected final S service;

    public ControllerImpl(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<BaseResponse> input(Input param) {
        return ResponseEntity.ok(service.input(param));
    }

    @Override
    public ResponseEntity<BaseResponse> modify(String uuid, Update param) {
        return ResponseEntity.ok(service.modify(uuid, param));
    }

    @Override
    public ResponseEntity<BaseResponse> remove(String uuid) {
        return ResponseEntity.ok(service.remove(uuid));
    }

    @Override
    public ResponseEntity<BaseResponse> get(String uuid) {
        return ResponseEntity.ok(service.get(uuid));
    }

    @Override
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
