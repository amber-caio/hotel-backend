package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.dtos.tickets.TicketDTO;
import com.caioamber.hotel.entities.enums.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="hospede")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Hospede implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private int idade;
    private Boolean ativo;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToOne(mappedBy = "fk_hospede")
    private Carro carro;

    @OneToOne(mappedBy = "fk_hospede")
    private Ticket ticket;

    public Hospede(HospedeCreateDTO data, String senha) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.idade = data.idade();
        this.ativo = true;
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
