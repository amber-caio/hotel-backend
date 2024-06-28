package com.caioamber.hotel.dtos.reservas;

import java.time.LocalDate;

public record ReservaCreateDTO(LocalDate data_inicio, LocalDate data_fim, Boolean status, Long id_quarto, String cpf) {

}
