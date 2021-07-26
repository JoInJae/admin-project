package com.superbrain.data.domain.base;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass public abstract class BaseDetailEntity {

    @Id
    private Long idx;

    @Column(name = "create_at", columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime time_create;

    @Column(name = "update_at", columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDateTime time_update;

}
