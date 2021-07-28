package com.superbrain.mvc.service.base;

import com.superbrain.data.dto.response.BaseResponse;

public interface Service<Input, Update>{

    BaseResponse input(Input param);
    BaseResponse modify(String uuid, Update param);
    BaseResponse remove(String uuid);
    BaseResponse get(String uuid);
    BaseResponse getAll();

}
