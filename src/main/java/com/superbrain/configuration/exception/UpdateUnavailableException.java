package com.superbrain.configuration.exception;

import lombok.Getter;

@Getter
public class UpdateUnavailableException extends RuntimeException{

    private final static String message = "업데이트를 할 수 없습니다.";

    public UpdateUnavailableException() {
        super(message);
    }

}
