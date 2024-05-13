package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;
    @Autowired


    /*

    Cadastro

    Caso o hospede ja exista, verificamos se ele ainda esta ativo, caso sim,
    retornamos que o hospede ja esta cadastrado, caso contrario
    apenas o reativamos em nosso sistema.

    Caso não exista, prosseguimos com a sua criação.

     */

    public HospedeDTO cadastro(HospedeCreateDTO data) {
        if (this.repository.findByCpf(data.cpf()) != null){

            Hospede hospede = this.repository.findByCpf(data.cpf());

            if (hospede.isAtivo()){
                throw new IllegalArgumentException("This CFP is already being used");
            }
            hospede.setAtivo(true);
            return new HospedeDTO(hospede);
        }
        return new HospedeDTO(repository.save(new Hospede(data)));
    }

    // Get All 'Hospedes' Ativos

    public List<HospedeDTO> getAll(){
        return repository.findAllByAtivoTrue().stream().map(HospedeDTO::new).toList();
    }

    // Get By CPF

    public HospedeDTO getByCPF(String cpf){
        if(repository.findByCpf(cpf) != null){
            return new HospedeDTO(repository.findByCpf(cpf));
        }
        throw new NotFoundException("Visitant not found!");
    }

    /*

    Status do Hospede

    Método utilizado para setar o status atual do Hóspede
    no caso Ativo ou Inativo (true or false)

     */

    public HospedeDTO alterarStatus(String cpf, Boolean ativo){
        if(this.repository.findByCpf(cpf) != null){
            Hospede hospede = this.repository.findByCpf(cpf);
            hospede.setAtivo(ativo);

            if(!hospede.isAtivo()){

            }

            return new HospedeDTO(hospede);
        }
        throw new NotFoundException("Visitant not found!");
    }
}
