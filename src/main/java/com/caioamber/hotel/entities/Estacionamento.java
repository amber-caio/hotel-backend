package com.caioamber.hotel.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="estacionamento")
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qtd_vagas_disponiveis;
    private int qtd_vagas_ocupadas;
}
