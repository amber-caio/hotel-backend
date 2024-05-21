package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.dtos.tickets.TicketDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="hospede")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private int idade;
    private Boolean ativo;

    @OneToOne(mappedBy = "fk_hospede")
    private Carro carro;

    @OneToOne(mappedBy = "fk_hospede")
    private Ticket ticket;

    public Hospede(HospedeCreateDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.idade = data.idade();
        this.ativo = true;
    }
}
