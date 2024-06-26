package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByCpf(String cpf);

    List<Funcionario> findAllByAtivoTrue();
}
