package com.caioamber.hotel.entities;

import com.caioamber.hotel.entities.enums.Tipo;
import jakarta.persistence.*;

@Entity
@Table(name="quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private boolean status;
    private double valor_diaria;
}
