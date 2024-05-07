package com.caioamber.hotel.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String turno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cardapio", referencedColumnName = "id")
    private Cardapio cardapio;
}
