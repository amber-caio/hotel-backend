package com.caioamber.hotel.dtos.hospedes;


import jakarta.validation.constraints.NotBlank;

public record HospedeStatusDTO(

        @NotBlank
        Boolean ativo

) {
}
