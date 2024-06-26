package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.tickets.TicketCreateDTO;
import com.caioamber.hotel.dtos.tickets.TicketDTO;
import com.caioamber.hotel.dtos.tickets.TicketStatusDTO;
import com.caioamber.hotel.entities.Ticket;
import com.caioamber.hotel.services.TicketService;
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
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService service;

    @PostMapping
    @Operation(summary = "Cadastrar Ticket",
            description = "Cadastrar Ticket",
            tags = {"Tickets"})
    @Transactional
    public ResponseEntity<TicketDTO> cadastrar(@RequestBody @Valid TicketCreateDTO data, UriComponentsBuilder uriBuilder){
        TicketDTO ticketDTO = service.cadastro(data);
        URI uri = uriBuilder.path("/tickets/{id}").buildAndExpand(ticketDTO.id()).toUri();
        return ResponseEntity.created(uri).body(ticketDTO);
    }

    @GetMapping
    @Operation(summary = "Listar Tickets",
            description = "Listar Tickets",
            tags = {"Tickets"})
    public ResponseEntity<List<TicketDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar Ticket",
            description = "Buscar Ticket",
            tags = {"Tickets"})
    public ResponseEntity<TicketDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(summary = "Alterar Status do Ticket",
            description = "Alterar Status do Ticket",
            tags = {"Tickets"})
    @Transactional
    public ResponseEntity<TicketDTO> alterarStatus(@PathVariable Long id, @RequestBody TicketStatusDTO ticketStatusDTO){
        return new ResponseEntity<>(service.alterarStatus(id, ticketStatusDTO.status()), HttpStatus.OK);
    }
}
