package com.caioamber.hotel.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="cardapio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Cardapio {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String entrada;
    private String pratoPrincipal;
    private String sobremesa;
    private boolean ativo;

    @OneToOne(mappedBy = "cardapio")
    private Restaurante restaurante;
}
