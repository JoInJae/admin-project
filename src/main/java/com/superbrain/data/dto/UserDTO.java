package com.superbrain.data.dto;

import com.superbrain.data.constant.Education;
import com.superbrain.data.constant.Gender;
import com.superbrain.data.domain.base.embeded.Birth;
import com.superbrain.data.domain.part.admin.Admin;
import com.superbrain.data.domain.part.user.User;
import com.superbrain.data.domain.part.user.UserAccount;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

public class UserDTO {

    @Data
    public static class Input{

        private String id;
        private String password;
        private String name;
        private Education education;
        private Gender gender;
        private Integer year;
        private Integer month;
        private Integer date;
        private Float height;

        public User toEntity(Admin admin){

            User user = User.builder()
                    .name(name).education(education).gender(gender).birth(new Birth(year, month, date)).height(height)
                    .admin(admin).build();

            UserAccount account = UserAccount.builder()
                    .id(id).password(password).user(user).build();

            user.setAccount(account);

            return user;

        }

    }

    @Data
    public static class Update{
        private String password;
    }

    @Getter
    public static class Result{

        private final String uuid;
        private final String id;
        private final String name;
        private final String gender;
        private final String education;
        private final Integer year;
        private final Integer month;
        private final Integer date;

        public Result(String uuid, String id, String name, Gender gender, Education education, Birth birth) {
            this.uuid = uuid;
            this.id = id;
            this.name = name;
            this.gender = gender.getKor();
            this.education = education.getScope();
            this.year = birth.getBirth_1();
            this.month = birth.getBirth_2();
            this.date = birth.getBirth_3();
        }
    }

    @Getter
    public static class ResultDetail{

        private final String uuid;
        private final String id;
        private final String name;
        private final String gender;
        private final String education;
        private final Integer year;
        private final Integer month;
        private final Integer date;
        private final Float height;
        private final LocalDateTime create_at;
        private final LocalDateTime update_at;


        public ResultDetail(String uuid, String id, String name, Gender gender, Education education, Birth birth, Float height, LocalDateTime create_at, LocalDateTime update_at) {
            this.uuid = uuid;
            this.id = id;
            this.name = name;
            this.gender = gender.getKor();
            this.education = education.getScope();
            this.year = birth.getBirth_1();
            this.month = birth.getBirth_2();
            this.date = birth.getBirth_3();
            this.height = height;
            this.create_at = create_at;
            this.update_at = update_at;
        }
    }

}
