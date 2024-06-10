package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.carros.CarroDTO;
import com.caioamber.hotel.dtos.restaurantes.RestauranteCreateDTO;
import com.caioamber.hotel.dtos.restaurantes.RestauranteDTO;
import com.caioamber.hotel.entities.Restaurante;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.CardapioRepository;
import com.caioamber.hotel.repositories.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository repository;

    @Autowired
    private CardapioRepository cardapioRepository;

    public RestauranteDTO cadastrar(RestauranteCreateDTO data){
        if(cardapioRepository.findByNome(data.nomeCardapio()) == null){
            throw new NotFoundException("Menu not found!");
        }

        Restaurante restaurante = new Restaurante(data);
        restaurante.setFk_cardapio(cardapioRepository.findByNome(data.nomeCardapio()));
        repository.save(restaurante);

        return new RestauranteDTO(restaurante);

    }
    public List<RestauranteDTO> getAll(){
        return repository.findAll().stream().map(RestauranteDTO::new).toList();
    }
    public RestauranteDTO getById   (Long id){
        return new RestauranteDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Restaurant not found!")));
    }
}
