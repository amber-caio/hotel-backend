package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.restaurantes.RestauranteCreateDTO;
import com.caioamber.hotel.dtos.restaurantes.RestauranteDTO;
import com.caioamber.hotel.services.RestauranteService;
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
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @PostMapping
    @Operation(summary = "Cadastrar Restaurante",
            description ="Cadastrar Restaurante",
            tags = {"Restaurantes"})
    @Transactional
    public ResponseEntity<RestauranteDTO> cadastrar(@RequestBody @Valid RestauranteCreateDTO data, UriComponentsBuilder uriBuilder){
        RestauranteDTO restauranteDTO = service.cadastrar(data);
        URI uri = uriBuilder.path("/restaurantes/{id}").buildAndExpand(restauranteDTO.id()).toUri();
        return ResponseEntity.created(uri).body(restauranteDTO);
    }

    @GetMapping
    @Operation(summary = "Listar Restaurantes",
            description ="Listar Restaurantes",
            tags = {"Restaurantes"})
    public ResponseEntity<List<RestauranteDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
