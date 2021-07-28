package com.superbrain.data.dto.response;

import com.superbrain.data.dto.response.type.Response;
import lombok.Getter;

import javax.annotation.Nullable;

@Getter
public class HaveBodyResponse<Body> extends BaseResponse{

    private final Body body;

    public HaveBodyResponse(Response response, @Nullable Body body) {
        super(response);
        this.body = body;
    }

}
