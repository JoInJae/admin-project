package com.superbrain.data.domain.base.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@AllArgsConstructor@NoArgsConstructor
@Data@Embeddable
public class Time {

    @Column(name = "create_at", columnDefinition = "DATETIME")
    private LocalDateTime create;
    @Column(name = "update_at", columnDefinition = "DATETIME")
    private LocalDateTime update;

}
