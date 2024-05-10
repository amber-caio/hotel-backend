package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.carros.CarroCreateDTO;
import com.caioamber.hotel.dtos.carros.CarroDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.services.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService service;

    @PostMapping
    @Operation(summary = "Cadastrar Carro",
            description ="Cadastrar Carro",
            tags = {"Carros"})
    @Transactional
    public ResponseEntity<CarroDTO> create(@RequestBody @Valid CarroCreateDTO data, UriComponentsBuilder uriBuilder){
        CarroDTO carro = service.cadastro(data);
        URI uri = uriBuilder.path(("/carros/{id}")).buildAndExpand(carro.id()).toUri();
        return ResponseEntity.created(uri).body(carro);
    }
}
