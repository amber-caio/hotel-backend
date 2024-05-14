package com.caioamber.hotel.dtos.carros;

import jakarta.validation.constraints.NotBlank;

public record CarroStatusDTO(@NotBlank boolean ativo) {
}
