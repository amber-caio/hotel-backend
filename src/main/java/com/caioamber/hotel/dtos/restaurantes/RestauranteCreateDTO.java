package com.caioamber.hotel.dtos.restaurantes;

import jakarta.validation.constraints.NotBlank;

public record RestauranteCreateDTO(@NotBlank String turno, @NotBlank String nomeCardapio) {
}
