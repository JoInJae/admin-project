package com.superbrain.mvc.controller.base;

abstract public class BaseController<S> {

    protected final S service;

    protected BaseController(S service) {
        this.service = service;
    }

}
