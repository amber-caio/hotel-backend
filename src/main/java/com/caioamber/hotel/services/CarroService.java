package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.carros.CarroCreateDTO;
import com.caioamber.hotel.dtos.carros.CarroDTO;
import com.caioamber.hotel.entities.Carro;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.CarroRepository;
import com.caioamber.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;
    @Autowired
    private HospedeRepository hospedeRepository;

    //  Cadastrar Carro

    public CarroDTO cadastro (CarroCreateDTO data) {

        if(repository.findByPlaca(data.placa()) != null){
            throw new IllegalArgumentException("Vehicle already registered in the system!");
        }

        if(hospedeRepository.findByCpf(data.cpfHospede()) == null){
            throw new NotFoundException("Visitant not found!");
        }

        Carro carro = new Carro(data);
        carro.setFk_hospede(hospedeRepository.findByCpf(data.cpfHospede()));
        repository.save(carro);

        return new CarroDTO(carro);
    }

    // Get All 'Carros' Ativos

    public List<CarroDTO> getAll(){
        return repository.findAllByAtivoTrue().stream().map(CarroDTO::new).toList();
    }

    
}
