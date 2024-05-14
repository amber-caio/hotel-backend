package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    List<Vaga> findAllByStatusFalse();
}
