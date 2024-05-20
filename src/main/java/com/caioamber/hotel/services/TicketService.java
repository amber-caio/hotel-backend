package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.tickets.TicketCreateDTO;
import com.caioamber.hotel.dtos.tickets.TicketDTO;
import com.caioamber.hotel.entities.Ticket;
import com.caioamber.hotel.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository repository;

    public TicketDTO cadastro(TicketCreateDTO data){
        Ticket ticket = new Ticket();

        repository.save(ticket);

        return new TicketDTO(ticket);
    }

    public List<TicketDTO> getAll(){
        return repository.findAllByStatusTrue().stream().map(TicketDTO::new).toList();
    }
}
