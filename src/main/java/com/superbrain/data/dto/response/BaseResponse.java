package com.superbrain.data.dto.response;

import com.superbrain.data.constant.Response;
import lombok.Getter;
import javax.annotation.Nullable;

@Getter
public abstract class BaseResponse {

    private final String type;
    private final String message;
    private final String status;

    public BaseResponse(Response response) {
        this.status = response.getStatus();
        this.message = response.getMessage();
        this.type = response.getType().getWord();
    }

    public static BaseResponse success(){
        return new DefaultResponse(Response.SUCCESS);
    }

    public static BaseResponse success (@Nullable Object body){
        return new HaveBodyResponse<>(Response.SUCCESS, body);
    }

    public static BaseResponse error(Response response){
        return new DefaultResponse(response);
    }

}
