package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.tickets.TicketCreateDTO;
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
    private String data_hora;
    private double total;
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_hospede", referencedColumnName = "id")
    private Hospede fk_hospede;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_vaga", referencedColumnName = "id")
    private Vaga fk_vaga;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_carro", referencedColumnName = "id")
    private Carro fk_carro;

    public Ticket(TicketCreateDTO data) {
        this.data_hora = data.data_hora();
        this.total = data.total();
        this.status = true;
    }
}
