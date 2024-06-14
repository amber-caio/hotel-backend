package com.caioamber.hotel.dtos.usuarios;

import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(@NotBlank String nome, @NotBlank String login, @NotBlank String senha) {
}
