package com.caioamber.hotel.entities;

import jakarta.persistence.*;

@Entity
@Table(name="vaga")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_carro", referencedColumnName = "id")
    private Carro carro;
}
