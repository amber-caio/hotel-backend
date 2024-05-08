package com.caioamber.hotel.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record HospedeCreateDTO(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @Positive
        int idade) {
}
