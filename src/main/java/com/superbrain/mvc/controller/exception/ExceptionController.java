package com.superbrain.mvc.controller.exception;

import com.superbrain.configuration.exception.ServiceException;
import com.superbrain.data.dto.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice public class ExceptionController {

    private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<BaseResponse> serviceException(ServiceException e){

        e.getStackTrace();

        return ResponseEntity.ok(BaseResponse.error(e.getResponse()));

    }

}
