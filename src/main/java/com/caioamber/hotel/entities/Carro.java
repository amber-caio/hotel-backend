package com.caioamber.hotel.entities;

import jakarta.persistence.*;

@Entity
@Table(name="carro")
public class Carro {
    @Id
    @GeneratedValue
    private Long id;
    private String placa;
    private String modelo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_hospede", referencedColumnName = "id")
    private Hospede hospede;

    @OneToOne(mappedBy = "carro")
    private Vaga vaga;
}
