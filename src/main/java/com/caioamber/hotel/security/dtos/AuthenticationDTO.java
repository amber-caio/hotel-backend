package com.caioamber.hotel.security.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(@NotBlank String nomeUsuario, @NotBlank String senha) {
}
