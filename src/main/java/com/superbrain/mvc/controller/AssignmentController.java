package com.superbrain.mvc.controller;

import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.service.AssignmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/assignment", method = RequestMethod.POST)
@RestController public class AssignmentController extends BaseController<AssignmentService> {

    protected AssignmentController(AssignmentService service) {
        super(service);
    }

}
