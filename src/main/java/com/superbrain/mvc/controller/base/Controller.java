package com.superbrain.mvc.controller.base;

import com.superbrain.data.dto.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface Controller <Input, Update>{

    @RequestMapping(path="/input", method = RequestMethod.POST)
    ResponseEntity<BaseResponse> input(@RequestParam(name = "admin", required = false) String admin, @ModelAttribute Input param);

    @RequestMapping(path="/modify", method = RequestMethod.POST)
    ResponseEntity<BaseResponse> modify(@RequestParam(name = "admin", required = false) String admin, @RequestParam(name = "uuid")String uuid, @ModelAttribute Update param);

    @RequestMapping(path="/remove", method = RequestMethod.POST)
    ResponseEntity<BaseResponse> remove(@RequestParam(name = "admin", required = false) String admin, @RequestParam(name = "uuid")String uuid);

    @RequestMapping(path="/get", method = RequestMethod.POST)
    ResponseEntity<BaseResponse> get(@RequestParam(name = "admin", required = false) String admin, @RequestParam(name = "uuid")String uuid);

    @RequestMapping(path="/get/all", method = RequestMethod.POST)
    ResponseEntity<BaseResponse> getAll(@RequestParam(name = "admin", required = false) String admin);

}
