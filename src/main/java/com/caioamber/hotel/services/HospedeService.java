package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.entities.Carro;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    public void saveHospede(Hospede hospede) {
        this.hospedeRepository.save(hospede);
    }

    public List<HospedeDTO> getAll(){
        return this.hospedeRepository.findAllByAtivoTrue().stream().map(HospedeDTO::new).toList();
    }

    public Object getByUsername(String nomeUsuario) {
        Optional<Hospede> hospede = hospedeRepository.findByNomeUsuario(nomeUsuario);

        if(hospede.isPresent()){
            return hospede.get();
        }
        throw new UsernameNotFoundException("Guest not found!" + nomeUsuario);
    }

    public HospedeDTO getByCPF(String cpf){
        if(hospedeRepository.findByCpf(cpf) != null){
            return new HospedeDTO(hospedeRepository.findByCpf(cpf));
        }
        throw new NotFoundException("Guest not found!");
    }

    public HospedeDTO alterarStatus(String cpf, Boolean ativo){
        if(this.hospedeRepository.findByCpf(cpf) != null){
            Hospede hospede = this.hospedeRepository.findByCpf(cpf);
            hospede.setAtivo(ativo);
            this.hospedeRepository.save(hospede);

            if(!hospede.getAtivo() && hospede.getCarro() != null) {
                Carro carro = hospede.getCarro();
                carro.setAtivo(false);
            }
            return new HospedeDTO(hospede);
        }
        throw new NotFoundException("Guest not found!");
    }

}
