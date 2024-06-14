package com.caioamber.hotel.dtos.usuarios;

import jakarta.validation.constraints.NotBlank;

public record UserAuthenticationDTO(@NotBlank String login, @NotBlank String senha) {
}
