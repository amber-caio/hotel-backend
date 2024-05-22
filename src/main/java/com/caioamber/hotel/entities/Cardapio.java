package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.cardapios.CardapioCreateDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="cardapio")
@Table(name="cardapio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String entrada;
    @Column(name="prato")
    private String prato;
    private String sobremesa;
    private Boolean ativo;

    @OneToOne(mappedBy = "fk_cardapio")
    private Restaurante restaurante;

    public Cardapio(CardapioCreateDTO data) {
        this.nome = data.nome();
        this.entrada = data.entrada();
        this.prato = data.prato();
        this.sobremesa = data.sobremesa();
        this.ativo = true;
    }
}
