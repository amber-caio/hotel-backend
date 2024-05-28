package com.caioamber.hotel.dtos.quartos;

import com.caioamber.hotel.entities.Quarto;
import com.caioamber.hotel.entities.enums.Tipo;

public record QuartoDTO(Long id, Tipo tipo, Boolean status, double valor_diaria) {
    public QuartoDTO(Quarto quarto){
        this(quarto.getId(),
                quarto.getTipo(),
                quarto.getStatus(),
                quarto.getValor_diaria());
    }
}
