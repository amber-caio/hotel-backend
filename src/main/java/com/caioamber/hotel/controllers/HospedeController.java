package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.hospedes.HospedeStatusDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.services.HospedeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeService service;

    // Cadastro

    @PostMapping
    @Operation(summary = "Cadastrar Hóspede",
            description ="Cadastrar Hóspede",
            tags = {"Hóspedes"})
    @Transactional
    public ResponseEntity<HospedeDTO> cadastrar (@RequestBody @Valid HospedeCreateDTO data,
                                                 UriComponentsBuilder uriBuilder) {
        HospedeDTO hospede = service.cadastro(data);
        URI uri = uriBuilder.path(("/hospedes/{id}")).buildAndExpand(hospede.cpf()).toUri();
        return ResponseEntity.created(uri).body(hospede);
    }

    // Listar Hospedes

    @GetMapping
    @Operation(summary = "Listar Hóspedes Ativos",
            description ="Listar Hóspedes",
            tags = {"Hóspedes"})
    public ResponseEntity<List<HospedeDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    // Get by CPF

    @GetMapping("{cpf}")
    @Operation(summary = "Buscar Hóspede por CPF",
            description ="Método utilizado para buscar um hóspede pelo seu CPF",
            tags = {"Hóspedes"})
    public ResponseEntity<HospedeDTO> getByCPF(@PathVariable String cpf){
        return new ResponseEntity<>(service.getByCPF(cpf), HttpStatus.OK);
    }

    // Alterar Status de um Hospede

    @PutMapping("/{cpf}")
    @Transactional
    @Operation(summary = "Alterar status de um Hospede!",
            description ="Método criado para alterar o status de um Hospede, espera uma entrada booleana!",
            tags = {"Hóspedes"})
    public ResponseEntity<HospedeDTO> alterarStatus (@PathVariable String cpf, @RequestBody @Valid HospedeStatusDTO status){
        return new ResponseEntity<>(service.alterarStatus(cpf , status.ativo()), HttpStatus.OK);
    }
}
