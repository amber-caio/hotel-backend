package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.carros.CarroCreateDTO;
import com.caioamber.hotel.dtos.carros.CarroDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
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

    // Get vehicle by placa
    public CarroDTO getByPlaca(String placa){
        if(repository.findByPlaca(placa) != null){
            return new CarroDTO(repository.findByPlaca(placa));
        }
        throw new NotFoundException("Vehicle not found!");
    }

    // Change vehicle status
    public CarroDTO alterarStatus(String placa, Boolean ativo){
        if(this.repository.findByPlaca(placa) != null) {
            Carro carro = this.repository.findByPlaca(placa);
            carro.setAtivo(ativo);
            return new CarroDTO(carro);
        }
        throw new NotFoundException("Vehicle not found!");
    }

}
