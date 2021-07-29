package com.superbrain.mvc.service.base;

import com.superbrain.data.dto.response.BaseResponse;

public interface Service<Input, Update>{

    default BaseResponse input(Input param){
        return BaseResponse.success();
    }

    default BaseResponse modify(String uuid, Update param){
        return BaseResponse.success();
    }

    default BaseResponse remove(String uuid){
        return BaseResponse.success();
    }

    default BaseResponse get(String uuid){
        return BaseResponse.success();
    }

    default BaseResponse getAll(){
        return BaseResponse.success();
    }

}
