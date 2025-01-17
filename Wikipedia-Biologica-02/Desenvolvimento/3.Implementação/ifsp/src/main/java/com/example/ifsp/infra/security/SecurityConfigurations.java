package com.example.ifsp.infra.security;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize.
                        requestMatchers(HttpMethod.GET, "/animais").permitAll().
                        requestMatchers(HttpMethod.POST, "/animais/adicionarAnimal").permitAll().
                        requestMatchers(HttpMethod.GET, "/animais/getDadosAnimal/**").permitAll().
                        requestMatchers(HttpMethod.GET, "/animais/pesquisar/**").permitAll().
                        requestMatchers(HttpMethod.POST, "/auth/login").permitAll().
                        requestMatchers(HttpMethod.OPTIONS, "/**").permitAll().
                        requestMatchers(HttpMethod.POST, "/auth/register").permitAll().
                        requestMatchers(HttpMethod.GET, "/auth/check").hasRole("ADMIN").
                        requestMatchers(HttpMethod.PUT, "/animais/atualizarAnimal/**").hasRole("ADMIN").
                        requestMatchers(HttpMethod.POST, "/animais/removerAnimal").hasRole("ADMIN").
                        requestMatchers(HttpMethod.HEAD, "/auth/check").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
