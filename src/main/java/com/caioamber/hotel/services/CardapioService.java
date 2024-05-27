package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.cardapios.CardapioCreateDTO;
import com.caioamber.hotel.dtos.cardapios.CardapioDTO;
import com.caioamber.hotel.entities.Cardapio;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {
    @Autowired
    private CardapioRepository repository;

    public CardapioDTO cadastro(CardapioCreateDTO data){
        if(repository.findByNome(data.nome()) != null){
            throw new IllegalArgumentException("Menu already created");
        }
        Cardapio cardapio = new Cardapio(data);

        repository.save(cardapio);

        return new CardapioDTO(cardapio);
    }

    public List<CardapioDTO> getAll(){
        return repository.findAllByAtivoTrue().stream().map(CardapioDTO::new).toList();
    }

    public CardapioDTO getByNome(String nome){
        if(repository.findByNome(nome) != null){
            return new CardapioDTO(repository.findByNome(nome));
        }
        throw new NotFoundException("Menu not found!");
    }

    public CardapioDTO alterarStatus(String nome, Boolean ativo){
        if(this.repository.findByNome(nome) != null){
            Cardapio cardapio = this.repository.findByNome(nome);
            cardapio.setAtivo(ativo);
            this.repository.save(cardapio);
            return new CardapioDTO(cardapio);
        }
        throw new NotFoundException("Menu not found!");
    }
}
