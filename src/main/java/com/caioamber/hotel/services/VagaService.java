package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.vagas.VagaCreateDTO;
import com.caioamber.hotel.dtos.vagas.VagaDTO;
import com.caioamber.hotel.entities.Vaga;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.CarroRepository;
import com.caioamber.hotel.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {
    @Autowired
    private VagaRepository repository;

    @Autowired
    private CarroRepository carroRepository;

    public VagaDTO cadastro(VagaCreateDTO data) {
        if(carroRepository.findByPlaca(data.placaCarro()) == null) {
            throw new NotFoundException("Vehicle not found!");
        }

        Vaga vaga = new Vaga();
        vaga.setFk_carro(carroRepository.findByPlaca(data.placaCarro()));
        repository.save(vaga);

        return new VagaDTO(vaga);
    }

    public List<VagaDTO> getAll(){
        return repository.findAllByStatusFalse().stream().map(VagaDTO::new).toList();
    }
}