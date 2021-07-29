package com.superbrain.data.domain.part.admin;

import com.superbrain.data.domain.base.BaseEntity;
import com.superbrain.data.domain.part.univ.Organization;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity@Table(name = "Admin")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "admin_idx", columnDefinition = "BIGINT", nullable = false)),
        @AttributeOverride(name = "uuid", column = @Column(name = "admin_uuid", columnDefinition = "CHAR(40)", nullable = false, unique = true))
})
public class Admin extends BaseEntity {


    @JoinColumn(name = "organization", referencedColumnName = "organization_idx")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Organization organization;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "admin")
    private AdminAccount account;

    public void setAccount(AdminAccount account) {
        this.account = account;
    }

    @Builder
    public Admin(Organization organization) {
        this.organization = organization;
    }

}
