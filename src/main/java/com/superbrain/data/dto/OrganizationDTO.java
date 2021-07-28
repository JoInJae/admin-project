package com.superbrain.data.dto;

import com.superbrain.data.constant.Role;
import com.superbrain.data.domain.universal.Organization;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class OrganizationDTO {

    @Data
    public static class Input{
        private String name;
        private Role role;
        private String etc;

        public Organization toEntity(){
            return Organization.builder()
                    .name(name).role(role).etc(etc).build();
        }
    }

    @Data
    public static class Update{
        private String name;
    }

    @Getter
    public static class Result{

        private String uuid;
        private String name;
        private String role;

        public Result(String uuid, String name, Role role) {
            this.uuid = uuid;
            this.name = name;
            this.role = role.getKor();
        }
    }

    @Getter
    public static class DetailResult{

        private String uuid;
        private String name;
        private String role;
        private String etc;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;

        public DetailResult(String uuid, String name, Role role, String etc, LocalDateTime createAt, LocalDateTime updateAt) {
            this.uuid = uuid;
            this.name = name;
            this.role = role.getKor();
            this.etc = etc;
            this.createAt = createAt;
            this.updateAt = updateAt;
        }

    }

}
