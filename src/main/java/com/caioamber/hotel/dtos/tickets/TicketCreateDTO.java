package com.caioamber.hotel.dtos.tickets;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TicketCreateDTO(

        String data_hora,

        double total,

        Boolean status,

        @NotBlank
        String cpfHospede,

        Long numVaga,

        @NotBlank
        String placaCarro
        ) {
}
