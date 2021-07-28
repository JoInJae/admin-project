package com.superbrain.data.dto.response.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Response {

    SUCCESS("0000", "작업 성공", Type.SUCCESS);

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
