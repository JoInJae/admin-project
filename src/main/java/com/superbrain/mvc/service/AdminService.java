package com.superbrain.mvc.service;

import com.superbrain.data.dto.AdminDTO;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface AdminService {
    void input(AdminDTO.Input param);
    void modify(String uuid, AdminDTO.Update param);
    void remove(String uuid);
    AdminDTO.Result get(String uuid);
    List<AdminDTO.Result> getAll();
    AdminDTO.Token login(AdminDTO.Login param, HttpServletResponse response);
    AdminDTO.Token reissue(String value);
}
