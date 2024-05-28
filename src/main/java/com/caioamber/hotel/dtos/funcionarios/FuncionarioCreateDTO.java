package com.caioamber.hotel.dtos.funcionarios;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FuncionarioCreateDTO(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        LocalDate data_admissao) {
}
