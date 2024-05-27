package com.caioamber.hotel.dtos.restaurantes;

import com.caioamber.hotel.entities.Restaurante;

public record RestauranteDTO(Long id, String turno) {
    public RestauranteDTO(Restaurante restaurante){
        this(restaurante.getId(), restaurante.getTurno());
    }
}
