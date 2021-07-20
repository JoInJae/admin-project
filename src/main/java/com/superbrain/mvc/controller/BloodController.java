package com.superbrain.mvc.controller;

import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.service.BloodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/blood", method = RequestMethod.POST)
@RestController public class BloodController extends BaseController<BloodService> {

    protected BloodController(BloodService service) {
        super(service);
    }

}
