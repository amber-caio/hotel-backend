package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.quartos.QuartoCreateDTO;
import com.caioamber.hotel.dtos.quartos.QuartoDTO;
import com.caioamber.hotel.entities.Quarto;
import com.caioamber.hotel.entities.Reserva;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.QuartoRepository;
import com.caioamber.hotel.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository repository;

    @Autowired
    private ReservaRepository reservaRepository;

    public QuartoDTO cadastrar(QuartoCreateDTO data){
        Quarto quarto = new Quarto(data);
        repository.save(quarto);

        return new QuartoDTO(quarto);
    }

    public List<QuartoDTO> getAll(){
        return repository.findAllByStatusTrue().stream().map(QuartoDTO::new).toList();
    }

    public QuartoDTO getById(Long id){
        return new QuartoDTO((repository.findById(id).orElseThrow(() -> new NotFoundException("Room not found!"))));
    }

    public QuartoDTO alterarStatus(Long id, Boolean ativo){
        Quarto quarto = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Room not found!"));
        quarto.setStatus(ativo);
        this.repository.save(quarto);

        return new QuartoDTO(quarto);
    }
}
