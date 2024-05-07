package com.caioamber.hotel.entities;

import com.caioamber.hotel.entities.enums.FormaPagamento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    private boolean status;
}
