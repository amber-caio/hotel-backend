package com.caioamber.hotel.dtos.reservas;

import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.entities.Quarto;

import java.time.LocalDate;

public record ReservaCreateDTO(LocalDate data_inicio, LocalDate data_fim, Boolean status, Long id_quarto, String cpf) {

}
