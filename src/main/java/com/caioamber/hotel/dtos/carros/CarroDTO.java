package com.caioamber.hotel.dtos.carros;

import com.caioamber.hotel.entities.Carro;

public record CarroDTO(

        Long id,
        String placa,
        String modelo,
        Boolean ativo

) {
    public CarroDTO(Carro carro) {
        this(carro.getId(), carro.getPlaca(), carro.getModelo(), carro.getAtivo());
    }
}
