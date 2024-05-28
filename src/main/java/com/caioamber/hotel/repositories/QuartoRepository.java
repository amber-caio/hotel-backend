package com.caioamber.hotel.repositories;

import com.caioamber.hotel.dtos.quartos.QuartoDTO;
import com.caioamber.hotel.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    List<Quarto> findAllByStatusTrue();
}
