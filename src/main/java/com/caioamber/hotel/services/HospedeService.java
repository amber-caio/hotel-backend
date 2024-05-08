package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDetalhamentoDTO;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;

    /*

    Cadastro

    Caso o hospede ja exista, verificamos se ele ainda esta ativo, caso sim,
    retornamos que o hospede ja esta cadastrado, caso contrario
    apenas o reativamos em nosso sistema.

    Caso não exista, prosseguimos com a sua criação.

     */

    public HospedeDetalhamentoDTO cadastro(HospedeCreateDTO data) {
        if (this.repository.findByCpf(data.cpf()) != null){

            Hospede hospede = this.repository.findByCpf(data.cpf());

            if (hospede.isAtivo()){
                throw new IllegalArgumentException("This CFP is already being used");
            }

            hospede.setAtivo(true);

            return new HospedeDetalhamentoDTO(hospede);
        }
        return new HospedeDetalhamentoDTO(repository.save(new Hospede(data)));
    }


    // Get All Hospedes

    public List<HospedeDetalhamentoDTO> getAll(){
        return repository.findAll().stream().map(HospedeDetalhamentoDTO::new).toList();
    }
}
