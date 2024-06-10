package com.caioamber.hotel.repositories;

import com.caioamber.hotel.dtos.quartos.QuartoDTO;
import com.caioamber.hotel.entities.Quarto;
import com.caioamber.hotel.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    List<Quarto> findAllByStatusTrue();

    Quarto findByReserva(Reserva reserva);
}
