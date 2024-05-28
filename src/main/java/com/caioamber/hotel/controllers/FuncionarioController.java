package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.funcionarios.FuncionarioCreateDTO;
import com.caioamber.hotel.dtos.funcionarios.FuncionarioDTO;
import com.caioamber.hotel.dtos.funcionarios.FuncionarioStatusDTO;
import com.caioamber.hotel.services.FuncionarioService;
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
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @PostMapping
    @Operation(summary = "Cadastrar Funcionário",
            description ="Cadastrar Funcionário",
            tags = {"Funcionários"})
    @Transactional
    public ResponseEntity<FuncionarioDTO> cadastrar(@RequestBody @Valid FuncionarioCreateDTO data, UriComponentsBuilder uriBuilder){
        FuncionarioDTO funcionarioDTO = service.cadastrar(data);
        URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionarioDTO.id()).toUri();
        return ResponseEntity.created(uri).body(funcionarioDTO);
    }

    @GetMapping
    @Operation(summary = "Listar Funcionários",
            description ="Listar Funcionários",
            tags = {"Funcionários"})
    public ResponseEntity<List<FuncionarioDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{cpf}")
    @Operation(summary = "Buscar Funcionário por CPF",
            description ="Buscar Funcionário por CPF",
            tags = {"Funcionários"})
    public ResponseEntity<FuncionarioDTO> getByCPF(@PathVariable String cpf){
        return new ResponseEntity<>(service.getByCpf(cpf), HttpStatus.OK);
    }

    @PutMapping("{cpf}")
    @Transactional
    @Operation(summary = "Alterar status de um funcionário",
            description ="Alterar status de um funcionário",
            tags = {"Funcionários"})
    public ResponseEntity<FuncionarioDTO> alterarStatus(@PathVariable String cpf, @RequestBody @Valid FuncionarioStatusDTO data){
       return new ResponseEntity<>(service.alterarStatus(cpf, data.ativo()), HttpStatus.OK);
    }


}
