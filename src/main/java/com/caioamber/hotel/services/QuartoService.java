package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.quartos.QuartoCreateDTO;
import com.caioamber.hotel.dtos.quartos.QuartoDTO;
import com.caioamber.hotel.entities.Quarto;
import com.caioamber.hotel.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository repository;

    public QuartoDTO cadastrar(QuartoCreateDTO data){
        Quarto quarto = new Quarto(data);
        repository.save(quarto);

        return new QuartoDTO(quarto);
    }

    public List<QuartoDTO> getAll(){
        return repository.findAllByStatusTrue().stream().map(QuartoDTO::new).toList();
    }
}
