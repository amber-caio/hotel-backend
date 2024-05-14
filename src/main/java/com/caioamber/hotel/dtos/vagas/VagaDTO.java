package com.caioamber.hotel.dtos.vagas;

import com.caioamber.hotel.entities.Vaga;

public record VagaDTO(Long id, boolean status) {

    public VagaDTO(Vaga vaga) {
        this(vaga.getId(), vaga.isStatus());
    }
}
