package com.superbrain.data.domain.admin;

import com.superbrain.data.domain.base.BaseEntity;
import com.superbrain.data.domain.base.embeded.Password;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.*;

@Entity@Table(name = "Admin")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "admin_idx", columnDefinition = "BIGINT", nullable = false)),
        @AttributeOverride(name = "uuid", column = @Column(name = "admin_uuid", columnDefinition = "CHAR(40)", nullable = false, unique = true))
})
public class Admin extends BaseEntity {

    @Column(name = "admin_id", columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
    private String id;

    @AttributeOverrides({
        @AttributeOverride(name = "hashing", column = @Column(name = "admin_password", columnDefinition = "CHAR(72)", nullable = false))
    })
    @Embedded
    private Password password;

    @Column(name = "admin_refresh", columnDefinition = "LONGTEXT")
    private String refresh;

    @Column(name = "admin_active", columnDefinition = "TINYINT(1)", nullable = false)
    private Long active;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "admin")
    @Setter
    private AdminInfo admin_info;

    @Builder
    public Admin(String id, String password, AdminInfo admin_info) {
        this.id = id;
        this.password = new Password(password, RandomStringUtils.randomAlphanumeric(12));
    }

    @PrePersist
    void preInsert(){
        this.active = 1L;
    }

}
