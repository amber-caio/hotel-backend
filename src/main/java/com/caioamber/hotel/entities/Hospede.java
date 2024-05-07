package com.caioamber.hotel.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="hospede")
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nome;
    private String cpf;
    private int idade;

    @OneToOne(mappedBy = "hospede")
    private Carro carro;
}
