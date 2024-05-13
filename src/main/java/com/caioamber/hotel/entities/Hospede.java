package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
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
    private boolean ativo;

    public Hospede(HospedeCreateDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.idade = data.idade();
        this.ativo = true;
    }

    public Hospede(HospedeDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.idade = data.idade();
        this.ativo = true;
    }
}
