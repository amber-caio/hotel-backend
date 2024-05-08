package com.caioamber.hotel.dtos.hospedes;

import com.caioamber.hotel.entities.Hospede;

public record HospedeDetalhamentoDTO(

        Long id,
        String nome,
        String cpf,
        int idade,
        boolean ativo
) {

    public HospedeDetalhamentoDTO(Hospede hospede) {
        this(hospede.getId(),
                hospede.getNome(),
                hospede.getCpf(),
                hospede.getIdade(),
                hospede.isAtivo()
        );
    }
}
