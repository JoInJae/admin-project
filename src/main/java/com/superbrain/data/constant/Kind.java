package com.superbrain.data.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Kind {

    G("Game","게임"),
    L("Learning","학습"),
    S("Survey","설문"),
    V("Video","영상");

    private final String eng;
    private final String kor;

}
