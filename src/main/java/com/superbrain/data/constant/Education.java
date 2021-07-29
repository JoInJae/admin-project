package com.superbrain.data.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Education {

    E0("None","없음", "0"),
    E1("Elementary","초등학교", "1 ~ 6"),
    E2("Middle","중학교", "7 ~ 9"),
    E3("High","고등학교", "10 ~ 12"),
    E4("University","대학교", "13 ~ 16"),
    E5("Elite","대학교이상", "16 +");

    private final String eng;
    private final String kor;
    private final String scope;

}
