package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.vagas.VagaCarroDTO;
import com.caioamber.hotel.dtos.vagas.VagaCreateDTO;
import com.caioamber.hotel.dtos.vagas.VagaDTO;
import com.caioamber.hotel.dtos.vagas.VagaStatusDTO;
import com.caioamber.hotel.entities.Carro;
import com.caioamber.hotel.entities.Hospede;
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
        if(carroRepository.findByPlaca(data.placaCarro()) == null && data.placaCarro() != "") {
            throw new NotFoundException("Vehicle not found!");
        }

        Vaga vaga = new Vaga();

        if(data.placaCarro() != ""){
            Carro carro = carroRepository.findByPlaca(data.placaCarro());
            vaga.setFk_carro(carro);
        } else{
            vaga.setFk_carro(null);
        }

        repository.save(vaga);

        return new VagaDTO(vaga);
    }

    public List<VagaDTO> getAll(){
        return repository.findAllByStatusFalse().stream().map(VagaDTO::new).toList();
    }

    public int getVagasDisponiveis(){
        return repository.findAllByStatusFalse().size();
    }

    public int getVagasIndisponiveis(){
        return repository.findAllByStatusTrue().size();
    }

    public VagaDTO getById(Long id){
        return new VagaDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Car space not found!")));
    }

    public VagaDTO alterarStatus(Long id, Boolean ativo){
        Vaga vaga = repository.findById(id).orElseThrow(() -> new NotFoundException("Car space not found!"));
        vaga.setStatus(ativo);
        this.repository.save(vaga);
        return new VagaDTO(vaga);
    }

    public VagaDTO cadastrarCarro(VagaCarroDTO data) {
        Vaga vaga = new Vaga();
        if(carroRepository.findByPlaca(data.placa()) != null && vaga.getStatus() == false){
            vaga.setFk_carro(carroRepository.findByPlaca(data.placa()));
            this.repository.save(vaga);
            return new VagaDTO(vaga);
        }
        throw new NotFoundException("Vehicle not found or Occupied car space ");
    }
}
