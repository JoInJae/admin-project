package com.superbrain.mvc.service;

import com.superbrain.data.dto.UserDTO;
import com.superbrain.data.dto.response.BaseResponse;
import com.superbrain.mvc.service.base.Service;

public interface UserService extends Service<UserDTO.Input, UserDTO.Update> {

    BaseResponse input(String unique, UserDTO.Input param);

}
