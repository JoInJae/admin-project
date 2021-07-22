package com.superbrain.data.environment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "aes256")
@ConstructorBinding
@AllArgsConstructor
@Getter
public class AESValues {
    private final String iv;
    private final String secret;
}
