package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.vagas.VagaCreateDTO;
import com.caioamber.hotel.dtos.vagas.VagaDTO;
import com.caioamber.hotel.dtos.vagas.VagaStatusDTO;
import com.caioamber.hotel.services.VagaService;
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
@RequestMapping("/vagas")
public class VagaController {
    @Autowired
    private VagaService service;

    @PostMapping
    @Operation(summary = "Cadastrar Vaga",
            description = "Cadastrar Vaga",
            tags = {"Vagas"})
    @Transactional
    public ResponseEntity<VagaDTO> cadastrar(@RequestBody @Valid VagaCreateDTO data, UriComponentsBuilder uriBuilder) {
        VagaDTO vagaDTO = service.cadastro(data);
        URI uri = uriBuilder.path(("/vagas/{id}")).buildAndExpand(vagaDTO.id()).toUri();
        return ResponseEntity.created(uri).body(vagaDTO);
    }

    @GetMapping()
    @Operation(summary = "Listar Vagas Disponíveis",
            description = "Listar Vagas Disponíveis",
            tags = {"Vagas"})
    public ResponseEntity<List<VagaDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/qtde-vagas-disponiveis")
    @Operation(summary = "Quantidade Vagas Disponíveis",
            description = "Quantidade Vagas Disponíveis",
            tags = {"Vagas"})
    public ResponseEntity<Integer> getQtdeVagasDisponiveis() {
        return new ResponseEntity<>(service.getVagasDisponiveis(), HttpStatus.OK);
    }

    @GetMapping("/qtde-vagas-indisponiveis")
    @Operation(summary = "Quantidade Vagas Indisponíveis",
            description = "Quantidade Vagas Indisponíveis",
            tags = {"Vagas"})
    public ResponseEntity<Integer> getQtdeVagasIndisponiveis() {
        return new ResponseEntity<>(service.getVagasIndisponiveis(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar vaga por id",
            description = "Buscar vaga por id",
            tags = {"Vagas"})
    public ResponseEntity<VagaDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(summary = "Alterar status de uma vaga",
            description = "Alterar status de uma vaga",
            tags = {"Vagas"})
    @Transactional
    public ResponseEntity<VagaDTO> alterarStatus(@PathVariable Long id, @RequestBody @Valid VagaStatusDTO vagaStatusDTO) {
        return new ResponseEntity<>(service.alterarStatus(id, vagaStatusDTO.status()), HttpStatus.OK);
    }
}
