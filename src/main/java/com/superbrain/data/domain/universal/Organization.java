package com.superbrain.data.domain.universal;

import com.superbrain.data.constant.Role;
import com.superbrain.data.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity@Table(name = "Organization")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "organization_idx", columnDefinition = "BIGINT", nullable = false)),
        @AttributeOverride(name = "uuid", column = @Column(name = "organization_uuid", columnDefinition = "CHAR(40)", nullable = false, unique = true))
})
public class Organization extends BaseEntity {

    @Column(name = "organization_name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @Column(name = "organization_role", columnDefinition = "CHAR(1)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


    @Column(name = "organization_etc", columnDefinition = "VARCHAR(200)")
    private String etc;

    @Builder
    public Organization(String name, Role role, String etc) {
        this.etc = etc;
        this.name = name;
        this.role = role;
    }

}
