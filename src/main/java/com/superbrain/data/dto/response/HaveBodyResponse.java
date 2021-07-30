package com.superbrain.data.dto.response;

import com.superbrain.data.constant.Response;
import lombok.Getter;

import javax.annotation.Nullable;

@Getter
public class HaveBodyResponse<Data> extends BaseResponse{

    private final Data data;

    public HaveBodyResponse(Response response, @Nullable Data data) {
        super(response);
        this.data = data;
    }

}
