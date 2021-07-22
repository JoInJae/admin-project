package com.superbrain.data.dto;

import com.superbrain.data.constant.Role;
import com.superbrain.data.domain.universal.Organization;
import lombok.Data;
import lombok.Getter;

public class OrganizationDTO {

    @Data
    public static class Input{
        private String name;
        private Role role;

        public Organization toEntity(){
            return Organization.builder()
                    .name(name).role(role).build();
        }
    }

    @Getter
    public static class Update{
        private String name;
    }

    @Getter
    public static class Result{
        private String name;
        private String role;
    }

}
