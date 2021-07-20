package com.superbrain.configuration.exception;

import lombok.Getter;

@Getter
public class InvalidAuthorizationException extends RuntimeException{

    private final static String message = "검증되지 않은 인증입니다.";

    public InvalidAuthorizationException() {
        super(message);
    }

}
