package com.superbrain.data.domain.part.user;

import com.superbrain.data.constant.Education;
import com.superbrain.data.constant.Gender;
import com.superbrain.data.domain.base.BaseEntity;
import com.superbrain.data.domain.base.embeded.Birth;
import com.superbrain.data.domain.part.admin.Admin;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity@Table(name = "User")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "user_idx", columnDefinition = "BIGINT", nullable = false)),
        @AttributeOverride(name = "uuid", column = @Column(name = "user_uuid", columnDefinition = "CHAR(40)", nullable = false, unique = true))
})
public class User extends BaseEntity {

    @Column(name = "user_name", columnDefinition = "VARCHAR(30)", nullable = false)
    private String name;

    @Column(name = "user_education", columnDefinition = "CHAR(2)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Education education;

    @Column(name = "user_gender", columnDefinition = "CHAR(1)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "user_height", columnDefinition = "FLOAT")
    private Float height;

    @AttributeOverrides({
            @AttributeOverride(name = "birth_1", column = @Column(name = "user_birth_year", columnDefinition = "INT(4)", nullable = false)),
            @AttributeOverride(name = "birth_2", column = @Column(name = "user_birth_month", columnDefinition = "INT(2)", nullable = false)),
            @AttributeOverride(name = "birth_3", column = @Column(name = "user_birth_date", columnDefinition = "INT(2)", nullable = false))
    })
    @Embedded
    private Birth birth;

    @JoinColumn(name = "admin", referencedColumnName = "admin_idx")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Admin admin;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "user")
    private UserAccount account;

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    @Builder
    public User(String name, Education education, Gender gender, Float height, Birth birth, Admin admin) {
        this.name = name;
        this.education = education;
        this.gender = gender;
        this.height = height;
        this.birth = birth;
        this.admin = admin;
    }

}
