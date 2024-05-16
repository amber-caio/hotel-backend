package com.caioamber.hotel.dtos.vagas;

import com.caioamber.hotel.entities.Vaga;

public record VagaDTO(Long id, Boolean status) {

    public VagaDTO(Vaga vaga) {
        this(vaga.getId(), vaga.isStatus());
    }
}
