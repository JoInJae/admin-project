package com.superbrain.data.domain.part.admin;

import com.superbrain.data.domain.base.BaseEntity;
import com.superbrain.data.domain.base.embeded.Password;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.*;

@Entity@Table(name = "Admin_Account")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "admin_idx", columnDefinition = "BIGINT", nullable = false))
})
public class AdminAccount extends BaseEntity {

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

    @JoinColumn(name = "admin_idx", referencedColumnName = "admin_idx")
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @MapsId
    private Admin admin;

    @Builder
    public AdminAccount(String id, String password, Admin admin) {
        this.id = id;
        this.password = new Password(password, RandomStringUtils.randomAlphanumeric(12));
        this.admin = admin;
    }

    @PrePersist
    void preInsert(){
        this.active = 1L;
    }

}
