package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    Hospede findByCpf(String cpf);
    List<Hospede> findAllByAtivoTrue();

    Optional<Hospede> findByNomeUsuario(String username);
}
