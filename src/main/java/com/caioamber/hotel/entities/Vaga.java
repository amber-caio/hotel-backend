package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.vagas.VagaCreateDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="vaga")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_carro", referencedColumnName = "id")
    private Carro fk_carro;

//    @OneToOne(mappedBy = "vaga")
//    private Ticket ticket;

}
