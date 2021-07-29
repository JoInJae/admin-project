package com.superbrain.data.domain.base.embeded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable public class Birth {

    private Integer birth_1;
    private Integer birth_2;
    private Integer birth_3;

}
