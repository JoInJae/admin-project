package com.superbrain.data.domain.admin;

import com.superbrain.data.domain.base.BaseDetailEntity;
import com.superbrain.data.domain.universal.Organization;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity@Table(name = "Admin_Info")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "admin_idx", columnDefinition = "BIGINT", nullable = false))
})
public class AdminInfo extends BaseDetailEntity {

    @JoinColumn(name = "admin_idx", referencedColumnName = "admin_idx")
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @MapsId
    private Admin admin;

    @JoinColumn(name = "organization", referencedColumnName = "organization_idx")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Organization organization;

    @Builder
    public AdminInfo(Admin admin, Organization organization) {
        this.admin = admin;
        this.organization = organization;
    }

}
