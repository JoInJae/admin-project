package com.superbrain.assist;

import com.superbrain.configuration.exception.InvalidAuthorizationException;
import com.superbrain.data.constant.Token;
import com.superbrain.data.environment.JWTValues;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Component public class JWT {

    private final JWTValues values;

    public JWT(JWTValues values) {
        this.values = values;
    }

    public String create(Token type, String uuid){

        Map<String, Object> claims = Map.of("uuid", uuid);

        long expiredTime = System.currentTimeMillis() + type.getExpiration();

        return Jwts.builder().signWith(setKey(), SignatureAlgorithm.HS256).setClaims(claims).setExpiration(new Date(expiredTime)).compact();

    }

    public Claims get(String input){

        try {

            return Jwts.parserBuilder().setSigningKey(setKey()).build().parseClaimsJws(input).getBody();

        }catch (ExpiredJwtException e){

            throw new InvalidAuthorizationException();

        }catch (Exception e){

            throw new InvalidAuthorizationException();

        }

    }

    private Key setKey(){

        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(values.getSecret()));

    }

}
