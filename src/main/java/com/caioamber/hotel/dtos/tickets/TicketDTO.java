package com.caioamber.hotel.dtos.tickets;

import com.caioamber.hotel.entities.Ticket;

import java.time.LocalDateTime;

public record TicketDTO(Long id, LocalDateTime data_hora, double total, Boolean status) {
    public TicketDTO(Ticket ticket){
        this(
            ticket.getId(),
            ticket.getData_hora(),
            ticket.getTotal(),
            ticket.getStatus());
    }

}
