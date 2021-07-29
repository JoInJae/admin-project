package com.superbrain.configuration.interceptor;


import com.superbrain.assist.JWT;
import com.superbrain.configuration.exception.InvalidAuthorizationException;
import com.superbrain.data.constant.Token;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component public class AuthorityInterceptor implements HandlerInterceptor {

    private final JWT jwt;

    public AuthorityInterceptor(JWT jwt) {
        this.jwt = jwt;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,  HttpServletResponse response,  Object handler) throws Exception {

        String authorization = request.getHeader("Authorization");

        if(authorization == null || !authorization.startsWith("Bearer")) throw new InvalidAuthorizationException();

        String token = authorization.replace("Bearer ", "");

        Claims claims = jwt.get(token);

        String uuid = (String)claims.get("uuid");
        Token type = (Token) claims.get("type");

        if(type != Token.ACCESS) throw new InvalidAuthorizationException();

        request.setAttribute("admin", uuid);

        return true;

    }
}
