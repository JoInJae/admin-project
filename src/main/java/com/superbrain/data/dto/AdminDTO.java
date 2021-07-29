package com.superbrain.data.dto;

import com.superbrain.data.domain.part.admin.Admin;
import com.superbrain.data.domain.part.admin.AdminAccount;
import com.superbrain.data.domain.part.univ.Organization;
import lombok.*;

import java.time.LocalDateTime;

public class AdminDTO {

    @Data
    public static class Input{
        private String id;
        private String password;
        private String organization;

        public Admin toEntity(Organization organization){

            Admin admin = Admin.builder()
                    .organization(organization)
                    .build();

            AdminAccount account = AdminAccount.builder()
                    .id(id).password(password).admin(admin).build();


            admin.setAccount(account);

            return admin;

        }

    }

    @Data
    public static class Update{
        private String password;
    }

    @Getter
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
    public static class ResultDetail{

        private String uuid;
        private String id;
        private String organization_name;
        private String organization_role;
        private LocalDateTime create_at;
        private LocalDateTime update_at;

        public ResultDetail(String uuid, String id, Organization organization, LocalDateTime create_at, LocalDateTime update_at) {
            this.uuid = uuid;
            this.id = id;
            this.organization_name = organization.getName();
            this.organization_role = organization.getRole().getKor();
            this.create_at = create_at;
            this.update_at = update_at;
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
