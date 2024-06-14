package com.caioamber.hotel.dtos.usuarios;

import jakarta.validation.constraints.NotBlank;

public record UserRoleDTO(@NotBlank UserRole role) {
}
