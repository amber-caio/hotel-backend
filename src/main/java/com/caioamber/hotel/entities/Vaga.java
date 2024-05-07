package com.caioamber.hotel.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="vaga")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_carro", referencedColumnName = "id")
    private Carro carro;

    @OneToOne(mappedBy = "vaga")
    private Ticket ticket;
}
