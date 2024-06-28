package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeStatusDTO;
import com.caioamber.hotel.security.dtos.AuthenticationDTO;
import com.caioamber.hotel.security.dtos.TokenJwtDTO;
import com.caioamber.hotel.security.services.AuthenticationService;
import com.caioamber.hotel.security.services.AuthorizationService;
import com.caioamber.hotel.services.HospedeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private HospedeService hospedeService;

    @PostMapping("/login")
    @Transactional
    @Operation(summary = "Fazer Login!",
            description ="Fazer Login!",
            tags = {"Hóspedes"})
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AuthenticationDTO data){
        return new ResponseEntity<>(authenticationService.loginAndCreateToken(data), HttpStatus.OK);
    }

    @PostMapping("/register")
    @Transactional
    @Operation(summary = "Register Guest",
            description ="Register Guest",
            tags = {"Hóspedes"})
    public ResponseEntity<HospedeDTO> registerGuest(@RequestBody @Valid HospedeCreateDTO data){
        return new ResponseEntity<>(authorizationService.registerGuest(data), HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Listar Hóspedes Ativos",
            description ="Listar Hóspedes",
            tags = {"Hóspedes"})
    public ResponseEntity<List<HospedeDTO>> getAll(){
        return new ResponseEntity<>(hospedeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{cpf}")
    @Operation(summary = "Buscar Hóspede por CPF",
            description ="Método utilizado para buscar um hóspede pelo seu CPF",
            tags = {"Hóspedes"})
    public ResponseEntity<HospedeDTO> getByCPF(@PathVariable String cpf){
        return new ResponseEntity<>(hospedeService.getByCPF(cpf), HttpStatus.OK);
    }

    @PutMapping("/{cpf}")
    @Transactional
    @Operation(summary = "Alterar status de um Hospede!",
            description ="Método criado para alterar o status de um Hospede, espera uma entrada booleana!",
            tags = {"Hóspedes"})
    public ResponseEntity<HospedeDTO> alterarStatus(@PathVariable String cpf, @RequestBody @Valid HospedeStatusDTO status){
        return new ResponseEntity<>(hospedeService.alterarStatus(cpf, status.ativo()), HttpStatus.OK);
    }


}