package com.caioamber.hotel.dtos.quartos;

import com.caioamber.hotel.entities.enums.Tipo;

public record QuartoCreateDTO(Tipo tipo, Boolean status, double valor_diaria) {
}
