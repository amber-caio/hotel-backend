package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.funcionarios.FuncionarioCreateDTO;
import com.caioamber.hotel.dtos.funcionarios.FuncionarioDTO;
import com.caioamber.hotel.entities.Funcionario;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioDTO cadastrar(FuncionarioCreateDTO data){
        if(repository.findByCpf(data.cpf()) != null){
            throw new IllegalArgumentException("Employee already created");
        }
        Funcionario funcionario = new Funcionario(data);
        repository.save(funcionario);
        return new FuncionarioDTO(funcionario);
    }

    public List<FuncionarioDTO> getAll(){
        return repository.findAllByAtivoTrue().stream().map(FuncionarioDTO::new).toList();
    }

    public FuncionarioDTO getByCpf(String cpf){
        if(repository.findByCpf(cpf) != null){
            return new FuncionarioDTO(repository.findByCpf(cpf));
        }
        throw new NotFoundException("Employee not found!");
    }

    public FuncionarioDTO alterarStatus(String cpf, Boolean ativo){
        if(repository.findByCpf(cpf) != null){
            Funcionario funcionario = repository.findByCpf(cpf);
            funcionario.setAtivo(ativo);
            repository.save(funcionario);

            return new FuncionarioDTO(funcionario);
        }
        throw new NotFoundException("Employee not found!");
    }
}
