package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
