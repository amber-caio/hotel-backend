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
        if (this.repository.findByCpf(data.cpf()) != null){
            throw new IllegalArgumentException("This CFP is already being used");
        }
        return new HospedeDetalhamentoDTO(repository.save(new Hospede(data)));
    }

    public List<HospedeDetalhamentoDTO> getAll(){
        return repository.findAll().stream().map(HospedeDetalhamentoDTO::new).toList();
    }
}
