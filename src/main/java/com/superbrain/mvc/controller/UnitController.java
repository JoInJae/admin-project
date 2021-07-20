package com.superbrain.mvc.controller;

import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.service.UnitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/unit", method = RequestMethod.POST)
@RestController public class UnitController extends BaseController<UnitService> {

    protected UnitController(UnitService service) {
        super(service);
    }

}
