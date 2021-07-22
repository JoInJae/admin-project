package com.superbrain.data.domain.base.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    S("Super","슈퍼 관리자"),
    C("Center","센터 관리자"),
    H("Hospital", "병원 관리자");

    private String eng;
    private String kor;

}
