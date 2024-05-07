package com.caioamber.hotel.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="carro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
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

    @OneToOne(mappedBy = "carro")
    private Ticket ticket;
}
