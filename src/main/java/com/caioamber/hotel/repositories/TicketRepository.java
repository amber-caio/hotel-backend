package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
