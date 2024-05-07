package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.HospedeCreateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

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

    @OneToOne(mappedBy = "hospede")
    private Carro carro;

    @OneToOne(mappedBy = "hospede")
    private Reserva reserva;

    public Hospede(HospedeCreateDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.idade = data.idade();
    }
}
