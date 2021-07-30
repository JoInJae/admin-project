package com.superbrain.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String index(){
        return "This is API Service";
    }

}
