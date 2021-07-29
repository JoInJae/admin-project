package com.superbrain.data.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {

    M("Male", "남"),
    F("Female", "여");

    private final String eng;
    private final String kor;

}
