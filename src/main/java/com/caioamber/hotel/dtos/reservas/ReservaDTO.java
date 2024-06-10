package com.caioamber.hotel.dtos.reservas;

import com.caioamber.hotel.entities.Reserva;

import java.time.LocalDate;

public record ReservaDTO(Long id, LocalDate data_inicio, LocalDate data_fim, Boolean status) {

    public ReservaDTO(Reserva reserva){
        this(reserva.getId(), reserva.getData_inicio(), reserva.getData_fim(), reserva.getStatus());
    }
}
