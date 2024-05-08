package com.caioamber.hotel.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HospedeStatusDTO(

        @NotBlank
        Boolean ativo

) {
}
