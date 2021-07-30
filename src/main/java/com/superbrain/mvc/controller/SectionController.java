package com.superbrain.mvc.controller;

import com.superbrain.data.dto.SectionDTO;
import com.superbrain.mvc.controller.base.BaseController;
import com.superbrain.mvc.service.SectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/section", method = RequestMethod.POST)
@RestController public class SectionController extends BaseController<SectionDTO.Input, SectionDTO.Update, SectionService> {

    protected SectionController(SectionService service) {
        super(service);
    }

}
