package com.superbrain.data.domain.base;

import com.superbrain.data.domain.base.converter.UuidConverter;
import com.superbrain.data.domain.base.embeded.Time;
import com.superbrain.data.domain.base.listener.UuidListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass@Getter
@EntityListeners(UuidListener.class)
public abstract class BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idx;

    @Convert(converter = UuidConverter.class)
    @Setter
    private String uuid;

    @Embedded
    private Time time;

    @PrePersist
    void preInsert(){
        time.setCreate(LocalDateTime.now());
        time.setUpdate(LocalDateTime.now());
    }

    @PreUpdate
    void preUpdate(){
        time.setUpdate(LocalDateTime.now());
    }


}
