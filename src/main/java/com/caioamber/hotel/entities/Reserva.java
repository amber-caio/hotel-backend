package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.reservas.ReservaCreateDTO;
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
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_quarto", referencedColumnName = "id")
    private Quarto fk_quarto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_hospede", referencedColumnName = "id")
    private Hospede fk_hospede;

    public Reserva(ReservaCreateDTO data) {
        this.id = data.id_quarto();
        this.data_inicio = data.data_inicio();
        this.data_fim = data.data_fim();
        this.status = data.status();
    }
}
