package com.nari.techshoppro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nari.techshoppro.security.JwtFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // SWAGGER APIs
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()

                        // PUBLIC APIs
                        .requestMatchers(
                                "/api/auth/**"
                        ).permitAll()

                        // ADMIN ONLY APIs
                        .requestMatchers(
                                "/api/admin/**"
                        ).hasRole("ADMIN")

                        // PRODUCT ADMIN APIs
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/products"
                        ).hasRole("ADMIN")

                        .requestMatchers(
                                HttpMethod.PUT,
                                "/api/products/**"
                        ).hasRole("ADMIN")

                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/products/**"
                        ).hasRole("ADMIN")

                        // PRODUCT VIEW APIs
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/products/**"
                        ).authenticated()

                        // CATEGORY ADMIN APIs
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/categories"
                        ).hasRole("ADMIN")

                        .requestMatchers(
                                HttpMethod.PUT,
                                "/api/categories/**"
                        ).hasRole("ADMIN")

                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/categories/**"
                        ).hasRole("ADMIN")

                        // CATEGORY VIEW APIs
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/categories/**"
                        ).authenticated()

                        // USER + ADMIN APIs
                        .requestMatchers(
                                "/api/cart/**"
                        ).authenticated()

                        .requestMatchers(
                                "/api/orders/**"
                        ).authenticated()

                        .requestMatchers(
                                "/api/payments/**"
                        ).authenticated()

                        .requestMatchers(
                                "/api/address/**"
                        ).authenticated()

                        .requestMatchers(
                                "/api/wishlist/**"
                        ).authenticated()

                        .requestMatchers(
                                "/api/reviews/**"
                        ).authenticated()

                        .requestMatchers(
                                "/api/users/**"
                        ).authenticated()

                        // ALL OTHER APIs
                        .anyRequest().authenticated()
                )

                .sessionManagement(session -> session

                        .sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}