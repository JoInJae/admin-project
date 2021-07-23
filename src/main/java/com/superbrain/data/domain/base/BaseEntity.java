package com.superbrain.data.domain.base;

import com.superbrain.data.domain.base.converter.UuidConverter;
import com.superbrain.data.domain.base.listener.UuidListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter@EntityListeners(UuidListener.class)
@MappedSuperclass public abstract class BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idx;

    @Convert(converter = UuidConverter.class)
    @Setter
    private String uuid;

    @Column(name = "create_at", columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime time_create;

    @Column(name = "update_at", columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDateTime time_update;

}
