package com.superbrain.data.dto;

import com.superbrain.data.domain.admin.Admin;
import com.superbrain.data.domain.admin.AdminInfo;
import com.superbrain.data.domain.universal.Organization;
import lombok.*;

public class AdminDTO {

    @Data
    public static class Input{
        private String id;
        private String password;
        private String organization;

        public Admin toEntity(Organization organization){

            Admin admin = Admin.builder()
                    .id(id).password(password).build();

            AdminInfo admin_info = AdminInfo.builder()
                    .organization(organization).admin(admin)
                    .build();

            admin.setAdmin_info(admin_info);

            return admin;

        }

    }

    @Data
    public static class Update{
        private String password;
    }

    @NoArgsConstructor
    @Data
    public static class Result{

        private String uuid;
        private String id;
        private String organization_name;
        private String organization_role;

        public Result(String uuid, String id, Organization organization) {
            this.uuid = uuid;
            this.id = id;
            this.organization_name = organization.getName();
            this.organization_role = organization.getRole().getKor();
        }

    }

    @Getter
    public static class Login{

        private String id;
        private String password;

    }

    @AllArgsConstructor
    @Builder
    @Getter
    public static class Token{

        private String access;

    }

}
