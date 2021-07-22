package com.superbrain.data.domain.base.listener;

import com.superbrain.assist.AES;
import com.superbrain.data.domain.base.BaseEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import java.util.UUID;

@Component public class UuidListener {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired private AES aes;

    @PrePersist
    void preInsert(BaseEntity entity){
        entity.setUuid(aes.encrypt(UUID.randomUUID().toString().replaceAll("-","") + RandomStringUtils.randomAlphanumeric(8)));
    }

}
