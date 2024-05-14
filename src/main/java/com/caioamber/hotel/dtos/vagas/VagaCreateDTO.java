package com.caioamber.hotel.dtos.vagas;

import jakarta.validation.constraints.NotBlank;

public record VagaCreateDTO(@NotBlank String placaCarro) {
}
