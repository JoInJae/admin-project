package com.superbrain.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration public class Security extends WebSecurityConfigurerAdapter {

    @Override protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests().anyRequest().permitAll();

        http.formLogin().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

}
