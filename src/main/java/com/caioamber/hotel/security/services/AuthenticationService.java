package com.caioamber.hotel.security.services;

import com.caioamber.hotel.entities.User;
import com.caioamber.hotel.security.dtos.AuthenticationDTO;
import com.caioamber.hotel.security.dtos.TokenJWTDTO;
import com.caioamber.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthenticationService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    public TokenJWTDTO loginAndCreateToken(AuthenticationDTO data){
//        UsernamePasswordAuthenticationToken userTest = new UsernamePasswordAuthenticationToken(data.username(), data.senha());
//        System.out.println("User: " + userTest.getPrincipal());
        try{
            Authentication user = manager.authenticate(new UsernamePasswordAuthenticationToken(data.username(), data.senha()));
            String tokenJWT = tokenService.gerarToken((User) user.getPrincipal());
            return new TokenJWTDTO(tokenJWT);
        } catch (AuthenticationException e){
            System.out.println("ENTREI CATCH");
            System.out.println("Service: Exception during client authentication: " + e.getMessage());
            throw new BadCredentialsException(e.getMessage());
        }
    }
}
