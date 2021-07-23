package com.superbrain.data.domain.base.converter;

import com.superbrain.assist.AES;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter public class UuidConverter implements AttributeConverter<String, String> {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private AES aes;

    @Override
    public String convertToDatabaseColumn(String input) {
        return aes.decrypt(input);
    }

    @Override
    public String convertToEntityAttribute(String db) {
        return aes.encrypt(db);
    }

}
