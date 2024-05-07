package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.HospedeCreateDTO;
import com.caioamber.hotel.dtos.HospedeDetalhamentoDTO;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {
    @Autowired
    private HospedeRepository repository;

    public HospedeDetalhamentoDTO cadastro(HospedeCreateDTO data) {
        Hospede hospede = new Hospede(data);

        repository.save(hospede);

        return new HospedeDetalhamentoDTO(hospede);
    }

    public List<HospedeDetalhamentoDTO> getAll(){
        return repository.findAll().stream().map(HospedeDetalhamentoDTO::new).toList();
    }


}
