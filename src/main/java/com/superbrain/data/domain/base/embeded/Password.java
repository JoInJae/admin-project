package com.superbrain.data.domain.base.embeded;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.Embeddable;

@NoArgsConstructor@Getter
@Embeddable public class Password {

    private String hashing;

    public Password(String password, String salt) {
        this.hashing = new BCryptPasswordEncoder().encode(password + salt) + salt;
    }

    public boolean match(String input){
        return new BCryptPasswordEncoder().matches(input + hashing.substring(60), hashing.substring(0, 60));
    }

}
