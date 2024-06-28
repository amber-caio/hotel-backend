package com.caioamber.hotel.security.services;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.exceptions.GenericsInactiveGuest;
import com.caioamber.hotel.security.dtos.AuthenticationDTO;
import com.caioamber.hotel.security.dtos.TokenJwtDTO;
import com.caioamber.hotel.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private HospedeDetailsServiceImpl hospedeDetailsService;

    @Autowired
    private HospedeService hospedeService;

    public TokenJwtDTO loginAndCreateToken(AuthenticationDTO data) {
        try {
            Hospede hospede = (Hospede) manager.authenticate(new UsernamePasswordAuthenticationToken(data.nomeUsuario(), data.senha())).getPrincipal();
            if(!hospede.getAtivo()){
                throw new GenericsInactiveGuest("Guest is inactive! You have to active the account before login");
            }
            System.out.println("Guest authenticated: " + hospede.getNomeUsuario());
            String tokenJWT = tokenService.gerarToken(hospede);
            return new TokenJwtDTO(tokenJWT);
        } catch (BadCredentialsException e){
            System.out.println("Something went wrong with auth: " + e.getMessage());
            throw new BadCredentialsException(e.getMessage());
        }
    }
}
