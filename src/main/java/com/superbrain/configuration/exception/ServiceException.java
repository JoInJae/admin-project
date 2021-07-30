package com.superbrain.configuration.exception;

import com.superbrain.data.constant.Response;
import lombok.Getter;

@Getter public class ServiceException extends RuntimeException{

    private final Response response;

    public ServiceException(Response response) {
        super(response.getMessage());
        this.response = response;
    }

}
