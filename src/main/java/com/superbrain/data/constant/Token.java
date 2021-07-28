package com.superbrain.data.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Token {

    ACCESS(1000L * 60 * 10),
    REFRESH(1000L * 60 * 60 * 24 * 7);

    private final Long expiration;

}
