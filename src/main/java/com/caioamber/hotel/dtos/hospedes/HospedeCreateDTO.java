package com.caioamber.hotel.dtos.hospedes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record HospedeCreateDTO(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @Positive
        @NotNull
        int idade
) {
}
