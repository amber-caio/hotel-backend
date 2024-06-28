package com.caioamber.hotel.security;

import com.caioamber.hotel.security.services.TokenService;
import com.caioamber.hotel.services.HospedeService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private HospedeService hospedeService;


    @Override
    protected void doFilterInternal(HttpServletRequest  request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (getToken(request) != null) {
            UserDetails hospede = (UserDetails) hospedeService.getByUsername(tokenService.getSubject(getToken(request)));

            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hospede, null, hospede.getAuthorities()));
        }
        filterChain.doFilter(request, response);
    }
    private String getToken(HttpServletRequest request){
        if(request.getHeader("Authorization") != null) {
            return request
                    .getHeader("Authorization")
                    .replace("Bearer ", "");
        }
        return null;
    }
}
