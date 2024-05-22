package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.cardapios.CardapioCreateDTO;
import com.caioamber.hotel.dtos.cardapios.CardapioDTO;
import com.caioamber.hotel.entities.Cardapio;
import com.caioamber.hotel.repositories.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {
    @Autowired
    private CardapioRepository repository;

    public CardapioDTO cadastro(CardapioCreateDTO data){
        Cardapio cardapio = new Cardapio(data);

        repository.save(cardapio);

        return new CardapioDTO(cardapio);
    }

    public List<CardapioDTO> getAll(){
        return repository.findAllByAtivoTrue().stream().map(CardapioDTO::new).toList();
    }
}
