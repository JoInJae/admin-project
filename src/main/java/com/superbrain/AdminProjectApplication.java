package com.superbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class AdminProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminProjectApplication.class, args);
    }

}
