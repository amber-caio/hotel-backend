package com.caioamber.hotel.security.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO (@NotBlank String username, @NotBlank String senha){
}
