package com.caioamber.hotel.dtos.funcionarios;

import com.caioamber.hotel.entities.Funcionario;

import java.time.LocalDate;

public record FuncionarioDTO(Long id, String nome, String cpf, LocalDate data_admissao, Boolean ativo) {

    public FuncionarioDTO(Funcionario funcionario){
        this(funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getData_admissao(),
                funcionario.getAtivo());
    }
}
