package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.entities.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="hospede")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hospede implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private int idade;
    private Boolean ativo;
    private String senha;

    @Column(name="nome_usuario")
    private String nomeUsuario;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToOne(mappedBy = "fk_hospede")
    private Carro carro;

    @OneToOne(mappedBy = "fk_hospede")
    private Ticket ticket;

    public Hospede(HospedeCreateDTO data, String senhaEncrypt){
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.idade = data.idade();
        this.ativo = true;
        this.senha = senhaEncrypt;
        this.nomeUsuario = data.nomeUsuario();
        this.role = Roles.ROLE_HOSPEDE;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_HOSPEDE"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nomeUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
