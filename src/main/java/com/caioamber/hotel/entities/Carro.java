package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.carros.CarroCreateDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="carro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private Boolean ativo;

    // FK de hospede na classe carro

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_hospede", referencedColumnName = "id")
    private Hospede fk_hospede;

    @OneToOne(mappedBy = "fk_carro")
    private Vaga vaga;

    public Carro(CarroCreateDTO data) {
        this.placa = data.placa();
        this.modelo = data.modelo();
        this.ativo = true;
    }
}
