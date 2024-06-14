package com.caioamber.hotel.configs;

import com.caioamber.hotel.security.filters.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests(req -> {

                req.requestMatchers(HttpMethod.GET, "/hospedes/**", "/hospede").permitAll();
                req.requestMatchers(HttpMethod.POST, "/hospedes/**", "/hospede").permitAll();
                req.requestMatchers(HttpMethod.PUT, "/hospedes/**", "/hospede").permitAll();

                req.requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll();
                req.requestMatchers("/usuarios","/usuarios/login", "/usuarios/register", "/usuarios/**").permitAll();

                req.anyRequest().authenticated();
            }).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
