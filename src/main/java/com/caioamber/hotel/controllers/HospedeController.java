package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.HospedeCreateDTO;
import com.caioamber.hotel.dtos.HospedeDetalhamentoDTO;
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

    @PostMapping
    @Operation(summary = "Cadastrar Hóspede",
            description ="Cadastrar Hóspede",
            tags = {"Hóspedes"})
    @Transactional
    public ResponseEntity<HospedeDetalhamentoDTO> cadastrar(@RequestBody @Valid HospedeCreateDTO data,
                                                                        UriComponentsBuilder uriBuilder) {
        HospedeDetalhamentoDTO hospede = service.cadastro(data);
        URI uri = uriBuilder.path(("/hospedes/{id}")).buildAndExpand(hospede.id()).toUri();

        return ResponseEntity.created(uri).body(hospede);
    }

    @GetMapping
    @Operation(summary = "Listar Hóspedes",
            description ="Listar Hóspedes",
            tags = {"Hóspedes"})
    public ResponseEntity<List<HospedeDetalhamentoDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
