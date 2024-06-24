package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.reservas.ReservaCreateDTO;
import com.caioamber.hotel.dtos.reservas.ReservaDTO;
import com.caioamber.hotel.dtos.reservas.ReservaStatusDTO;
import com.caioamber.hotel.services.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @PostMapping
    @Operation(summary = "Cadastrar Reserva",
            description = "Cadastrar Reserva",
            tags = {"Reservas"})
    @Transactional
    public ResponseEntity<ReservaDTO> cadastrar(@RequestBody ReservaCreateDTO data, UriComponentsBuilder uriBuilder){
        ReservaDTO reservaDTO = service.cadastrar(data);
        URI uri = uriBuilder.path("/reservas/{id}").buildAndExpand(reservaDTO.id()).toUri();
        return ResponseEntity.created(uri).body(reservaDTO);
    }

    @GetMapping
    @Operation(summary = "Listar Reservas",
            description = "Listar Reservas",
            tags = {"Reservas"})
    public ResponseEntity<List<ReservaDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Reserva",
            description = "Buscar Reserva",
            tags = {"Reservas"})
    public ResponseEntity<ReservaDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(summary = "Alterar Status da Reserva",
            description = "Alterar Status da Reserva",
            tags = {"Reservas"})
    @Transactional
    public ResponseEntity<ReservaDTO> alterarStatus(@PathVariable Long id, @RequestBody ReservaStatusDTO data){
        return new ResponseEntity<>(service.alterarStatus(id, data.status()), HttpStatus.OK);
    }

//    @GetMapping("/listar/usuario")
//    @Operation(summary = "Listar Reservas por Username",
//            description = "Listar Reservas por Username",
//            tags = {"Reservas"})
//    public ResponseEntity<ReservaDTO> getAllByUsername(){
//        return new ResponseEntity<>(service.getAllByUsername(), HttpStatus.OK);
//    }

}
