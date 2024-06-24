package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.security.dtos.AuthenticationDTO;
import com.caioamber.hotel.security.dtos.TokenJWTDTO;
import com.caioamber.hotel.security.services.AuthenticationService;
import com.caioamber.hotel.security.services.AuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    @Operation(summary = "Fazer Login!",
            description ="Fazer Login!",
            tags = {"Auth"})
    public ResponseEntity<TokenJWTDTO> login(@RequestBody @Valid AuthenticationDTO data){
        return new ResponseEntity<>(authenticationService.loginAndCreateToken(data), HttpStatus.OK);
    }

    @PostMapping("/register/client")
    @Operation(summary = "Register a client!",
            description ="Register a client!",
            tags = {"Auth"})
    public ResponseEntity<HospedeDTO> register(@RequestBody @Valid HospedeCreateDTO data){
        return new ResponseEntity<>(authorizationService.register(data), HttpStatus.OK);
    }
}
