package com.caioamber.hotel.dtos.cardapios;

import com.caioamber.hotel.entities.Cardapio;

public record CardapioDTO(Long id, String nome, String entrada, String prato, String sobremesa, Boolean ativo) {

    public CardapioDTO(Cardapio cardapio){
        this(
            cardapio.getId(),
            cardapio.getNome(),
            cardapio.getEntrada(),
            cardapio.getPrato(),
            cardapio.getSobremesa(),
            cardapio.getAtivo());
    }
}
