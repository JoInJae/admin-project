package com.superbrain.data.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    S("Super", "슈퍼 관리자"),
    H("Hospital", "병원 관리자"),
    C("Center", "센터 관리자");

    private final String eng;
    private final String kor;

}
