package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.carros.CarroCreateDTO;
import com.caioamber.hotel.dtos.carros.CarroDTO;
import com.caioamber.hotel.entities.Carro;
import com.caioamber.hotel.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public CarroDTO cadastro (CarroCreateDTO data){
        Carro carro = new Carro(data);
        repository.save(carro);

        return new CarroDTO(carro);
    }

}
