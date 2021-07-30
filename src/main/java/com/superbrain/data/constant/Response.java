package com.superbrain.data.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Response {

    //Success
    SUCCESS("0000", "작업 성공", Type.SUCCESS),
    //Fail
    ID_NOT_AVAILABLE("0001", "로그인 실패", Type.FAIL),
    PW_NOT_AVAILABLE("0002", "로그인 실패", Type.FAIL),

    TOKEN_NOT_EXIST("0003", "토큰 형식이 불일치", Type.FAIL),
    TOKEN_TYPE_NOT_AVAILABLE("0004", "유효하지 않은 토큰 타입", Type.FAIL),
    TOKEN_EXPIRED("0005", "만료된 토큰", Type.FAIL),
    TOKEN_INVALID("0006", "유효하지 않은 토큰", Type.FAIL);

    private final String status;
    private final String message;
    private final Type type;

    @AllArgsConstructor
    @Getter
    public enum Type{
        SUCCESS("Success"), FAIL("Fail"), ERROR("Error");
        private final String word;
    }

}
