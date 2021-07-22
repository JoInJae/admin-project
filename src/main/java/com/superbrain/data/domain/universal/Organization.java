package com.superbrain.data.domain.universal;

import com.superbrain.data.constant.Role;
import com.superbrain.data.domain.base.BaseEntity;
import com.superbrain.data.domain.base.embeded.Time;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity@Table(name = "Organization")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "org_idx", columnDefinition = "BIGINT", nullable = false)),
        @AttributeOverride(name = "uuid", column = @Column(name = "org_uuid", columnDefinition = "CHAR(40)", nullable = false, unique = true))
})
public class Organization extends BaseEntity {

    @Column(name = "org_name", columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String name;

    @Column(name = "org_role", columnDefinition = "CHAR(1)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private Time time;

    @Builder
    public Organization(String name, Role role) {
        this.name = name;
        this.role = role;
    }

}
