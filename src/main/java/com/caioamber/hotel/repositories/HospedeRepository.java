package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
}
