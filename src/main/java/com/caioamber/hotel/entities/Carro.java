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
    @GeneratedValue
    private Long id;
    private String placa;
    private String modelo;
    private boolean ativo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_hospede", referencedColumnName = "id")
    private Hospede hospede;

    @OneToOne(mappedBy = "carro")
    private Vaga vaga;

    @OneToOne(mappedBy = "carro")
    private Ticket ticket;

    public Carro(CarroCreateDTO data) {
        this.placa = data.placa();
        this.modelo = data.modelo();
        this.ativo = true;
        this.hospede = data.cpfHospede();
    }
}
