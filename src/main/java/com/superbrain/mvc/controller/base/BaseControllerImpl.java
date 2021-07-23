package com.superbrain.mvc.controller.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface BaseControllerImpl <Input, Update, Result>{

    @RequestMapping(path="/input", method = RequestMethod.POST)
    void input(@ModelAttribute Input param);

    @RequestMapping(path="/modify", method = RequestMethod.POST)
    void modify(@RequestParam(name = "uuid")String uuid, @ModelAttribute Update param);

    @RequestMapping(path="/remove", method = RequestMethod.POST)
    void remove(@RequestParam(name = "uuid")String uuid);

    @RequestMapping(path="/get", method = RequestMethod.POST)
    ResponseEntity<Result> get(@RequestParam(name = "uuid")String uuid);

    @RequestMapping(path="/get/all", method = RequestMethod.POST)
    ResponseEntity<List<Result>> getAll();

}
