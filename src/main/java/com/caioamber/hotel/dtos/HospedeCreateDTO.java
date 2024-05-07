package com.caioamber.hotel.dtos;

import jakarta.validation.constraints.NotBlank;

public record HospedeCreateDTO(@NotBlank String nome, @NotBlank String cpf, int idade) {
}
