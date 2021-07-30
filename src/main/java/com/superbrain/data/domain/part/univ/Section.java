package com.superbrain.data.domain.part.univ;

import com.superbrain.data.constant.Kind;
import com.superbrain.data.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity@Table(name = "Section")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "section_idx", columnDefinition = "BIGINT", nullable = false)),
        @AttributeOverride(name = "uuid", column = @Column(name = "section_uuid", columnDefinition = "CHAR(40)", nullable = false, unique = true))
})
public class Section extends BaseEntity {

    @Column(name = "section_name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @Column(name = "section_kind", columnDefinition = "CHAR(1)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Kind kind;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_parent", referencedColumnName = "section_idx")
    private Section section;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    private Set<Section> sections = new LinkedHashSet<>();

}
