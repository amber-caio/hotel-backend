package com.caioamber.hotel.dtos.tickets;

import java.time.LocalDateTime;

public record TicketCreateDTO(LocalDateTime data_hora, double total, Boolean status) {
}
