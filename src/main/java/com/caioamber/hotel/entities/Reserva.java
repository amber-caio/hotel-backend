package com.caioamber.hotel.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private boolean status;

    // Relacionar a classe Quarto
}
