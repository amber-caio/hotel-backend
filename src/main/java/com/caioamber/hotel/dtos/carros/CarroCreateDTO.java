package com.caioamber.hotel.dtos.carros;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CarroCreateDTO(
        @NotBlank
        @Size(max = 7, min = 7)
        String placa,
        @NotBlank
        String modelo,

        @NotBlank
        String cpfHospede
) {
}
