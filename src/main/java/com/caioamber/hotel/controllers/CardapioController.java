package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.cardapios.CardapioStatusDTO;
import com.caioamber.hotel.dtos.cardapios.CardapioCreateDTO;
import com.caioamber.hotel.dtos.cardapios.CardapioDTO;
import com.caioamber.hotel.services.CardapioService;
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
@RequestMapping("/cardapios")
public class CardapioController {
    @Autowired
    private CardapioService service;

    @PostMapping
    @Operation(summary = "Cadastrar Cardápio",
            description ="Cadastrar Cardápio",
            tags = {"Cardápios"})
    @Transactional
    public ResponseEntity<CardapioDTO> cadastrar(@RequestBody @Valid CardapioCreateDTO data, UriComponentsBuilder uriBuilder){
        CardapioDTO cardapioDTO = service.cadastro(data);
        URI uri = uriBuilder.path(("/cardapios/{id}")).buildAndExpand(cardapioDTO.id()).toUri();
        return ResponseEntity.created(uri).body(cardapioDTO);
    }

    @GetMapping
    @Operation(summary = "Listar Cardápios",
            description ="Listar Cardápios",
            tags = {"Cardápios"})
    public ResponseEntity<List<CardapioDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{nome}")
    @Operation(summary = "Buscar cardápio por nome",
            description ="Buscar cardápio por nome",
            tags = {"Cardápios"})
    public ResponseEntity<CardapioDTO> getByNome(@PathVariable String nome){
        return new ResponseEntity<>(service.getByNome(nome), HttpStatus.OK);
    }

    @PutMapping("{nome}")
    @Operation(summary = "Alterar status do cardápio",
            description ="Alterar status do cardápio",
            tags = {"Cardápios"})
    public ResponseEntity<CardapioDTO> alterarStatus(@PathVariable String nome, @RequestBody @Valid CardapioStatusDTO data){
        return new ResponseEntity<>(service.alterarStatus(nome, data.ativo()), HttpStatus.OK);
    }
}
