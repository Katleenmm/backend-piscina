package com.example.backend_piscina.entities;

import com.example.backend_piscina.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final ClienteService clienteService;

    @Autowired
    public SecurityConfig(@Lazy ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desabilita CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // permite todas as requisições sem autenticação
                );

        return http.build();
    }
}
