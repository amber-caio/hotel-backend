package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findAllByStatusTrue();
}
