package com.caioamber.hotel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data_hora;
    private double total;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_hospede", referencedColumnName = "id")
    private Hospede hospede;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_vaga", referencedColumnName = "id")
    private Vaga vaga;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_carro", referencedColumnName = "id")
    private Carro carro;
}
