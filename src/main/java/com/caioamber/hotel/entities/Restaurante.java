package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.restaurantes.RestauranteCreateDTO;
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
    @JoinColumn(name="fk_cardapio", referencedColumnName = "id")
    private Cardapio fk_cardapio;

    public Restaurante(RestauranteCreateDTO data) {
        this.turno = data.turno();
    }
}
