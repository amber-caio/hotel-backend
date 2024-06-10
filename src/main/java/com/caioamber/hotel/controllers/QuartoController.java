package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.quartos.QuartoCreateDTO;
import com.caioamber.hotel.dtos.quartos.QuartoDTO;
import com.caioamber.hotel.dtos.quartos.QuartoStatusDTO;
import com.caioamber.hotel.services.QuartoService;
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
@RequestMapping("/quartos")
public class QuartoController {
    @Autowired
    private QuartoService service;

    @PostMapping
    @Operation(summary = "Cadastrar Quarto",
            description = "Cadastrar Quarto",
            tags = {"Quartos"})
    @Transactional
    public ResponseEntity<QuartoDTO> cadastrar(@RequestBody @Valid QuartoCreateDTO data, UriComponentsBuilder uriBuilder){
        QuartoDTO quartoDTO = service.cadastrar(data);
        URI uri = uriBuilder.path("/quartos/{id}").buildAndExpand(quartoDTO.id()).toUri();
        return ResponseEntity.created(uri).body(quartoDTO);
    }

    @GetMapping
    @Operation(summary = "Listar Quartos",
            description = "Listar Quartos",
            tags = {"Quartos"})
    public ResponseEntity<List<QuartoDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar Quarto por ID",
            description ="Buscar Quarto por ID",
            tags = {"Quartos"})
    public ResponseEntity<QuartoDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    @Operation(summary = "Alterar Status do Quarto",
            description = "Alterar Status do Quarto",
            tags = {"Quartos"})
    @Transactional
    public ResponseEntity<QuartoDTO> alterarStatus(@PathVariable Long id, @RequestBody QuartoStatusDTO data){
        return new ResponseEntity<>(service.alterarStatus(id, data.status()), HttpStatus.OK);
    }
}
