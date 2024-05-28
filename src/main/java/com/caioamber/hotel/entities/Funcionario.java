package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.funcionarios.FuncionarioCreateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate data_admissao;
    private Boolean ativo;

    public Funcionario(FuncionarioCreateDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.data_admissao = data.data_admissao();
        this.ativo = true;
    }
}
