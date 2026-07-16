package com.example.crud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                            "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/items",
                                "/items/**",
                                "/error"
                        ).permitAll().anyRequest().authenticated()
                );
        return httpSecurity.build();
    }
}
