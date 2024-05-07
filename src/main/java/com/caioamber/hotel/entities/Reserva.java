package com.caioamber.hotel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="reserva")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_quarto", referencedColumnName = "id")
    private Quarto quarto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_hospede", referencedColumnName = "id")
    private Hospede hospede;
}
