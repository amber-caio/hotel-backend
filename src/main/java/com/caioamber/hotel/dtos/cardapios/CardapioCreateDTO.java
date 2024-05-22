package com.caioamber.hotel.dtos.cardapios;

import jakarta.validation.constraints.NotBlank;

public record CardapioCreateDTO(@NotBlank String nome, @NotBlank String entrada, @NotBlank String prato, @NotBlank String sobremesa, Boolean ativo){
}
