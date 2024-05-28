package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.quartos.QuartoCreateDTO;
import com.caioamber.hotel.entities.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="quarto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private Boolean status;
    private double valor_diaria;

    @OneToOne(mappedBy = "fk_quarto")
    private Reserva reserva;

    public Quarto(QuartoCreateDTO data) {
        this.tipo = data.tipo();
        this.status = data.status();
        this.valor_diaria = data.valor_diaria();
    }
}
