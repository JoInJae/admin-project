package com.superbrain.data.domain.part.user;

import com.superbrain.data.domain.base.BaseEntity;
import com.superbrain.data.domain.base.embeded.Password;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.*;

@Entity@Table(name = "User_Account")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "user_idx", columnDefinition = "BIGINT", nullable = false)),
        @AttributeOverride(name = "uuid", column = @Column(name = "user_uuid", columnDefinition = "CHAR(40)", nullable = false, unique = true))
})
public class UserAccount extends BaseEntity {

    @Column(name = "user_id", columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
    private String id;

    @AttributeOverrides({
        @AttributeOverride(name = "hashing", column = @Column(name = "user_password", columnDefinition = "CHAR(72)", nullable = false))
    })
    @Embedded
    private Password password;

    @Column(name = "user_refresh", columnDefinition = "LONGTEXT")
    private String refresh;

    @Column(name = "user_active", columnDefinition = "TINYINT(1)", nullable = false)
    private Long active;

    @JoinColumn(name = "user_idx", referencedColumnName = "user_idx")
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @MapsId
    private User user;

    @Builder
    public UserAccount(String id, String password, User user) {
        this.id = id;
        this.password = new Password(password, RandomStringUtils.randomAlphanumeric(12));
        this.user = user;
    }

    @PrePersist
    void preInsert(){
        this.active = 1L;
    }

}
