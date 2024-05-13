package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    Carro findByPlaca(String placa);
    List<Carro> findAllByAtivoTrue();
}
