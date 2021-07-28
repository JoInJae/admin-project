package com.superbrain.mvc.service;

import com.superbrain.data.dto.AdminDTO;
import com.superbrain.mvc.service.base.Service;
import javax.servlet.http.HttpServletResponse;

public interface AdminService extends Service<AdminDTO.Input, AdminDTO.Update> {
    AdminDTO.Token login(AdminDTO.Login param, HttpServletResponse response);
    AdminDTO.Token reissue(String value);
}
