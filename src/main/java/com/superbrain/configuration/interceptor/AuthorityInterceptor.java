package com.superbrain.configuration.interceptor;

import com.superbrain.assist.JWT;
import com.superbrain.configuration.exception.ServiceException;
import com.superbrain.data.constant.Response;
import com.superbrain.data.constant.Token;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
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
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {

        String authorization = request.getHeader("Authorization");

        if(authorization == null || !authorization.startsWith("Bearer")) throw new ServiceException(Response.TOKEN_NOT_EXIST);

        String token = authorization.replace("Bearer ", "");

        Claims claims = jwt.get(token);

        String uuid = (String)claims.get("uuid");
        Token type = (Token) claims.get("type");

        if(type != Token.ACCESS) throw new ServiceException(Response.TOKEN_TYPE_NOT_AVAILABLE);

        request.setAttribute("admin", uuid);

        return true;

    }
}
