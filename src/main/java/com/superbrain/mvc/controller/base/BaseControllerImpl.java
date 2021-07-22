package com.superbrain.mvc.controller.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface BaseControllerImpl <Input, Update, Result>{

    @RequestMapping(path="/input", method = RequestMethod.POST)
    void input(@ModelAttribute Input param);

    @RequestMapping(path="/modify", method = RequestMethod.POST)
    void modify(@ModelAttribute Update param);

    @RequestMapping(path="/remove/{uuid}", method = RequestMethod.POST)
    void remove(@PathVariable(name = "uuid")String uuid);

    @RequestMapping(path="/get/{uuid}", method = RequestMethod.POST)
    ResponseEntity<Result> get(@PathVariable(name = "uuid")String uuid);

    @RequestMapping(path="/get/all", method = RequestMethod.POST)
    ResponseEntity<List<Result>> getAll();

}
