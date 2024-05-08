package com.caioamber.hotel.dtos.hospedes;

import com.caioamber.hotel.entities.Hospede;

public record HospedeDTO(

        Long id,
        String nome,
        String cpf,
        int idade,
        boolean ativo
) {

    public HospedeDTO(Hospede hospede) {
        this(hospede.getId(),
                hospede.getNome(),
                hospede.getCpf(),
                hospede.getIdade(),
                hospede.isAtivo()
        );
    }
}
