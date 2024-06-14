package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
    List<Cardapio> findAllByAtivoTrue();

    Cardapio findByNome(String nome);
}
