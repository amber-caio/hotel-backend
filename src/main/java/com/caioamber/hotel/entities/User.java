package com.caioamber.hotel.entities;
import com.caioamber.hotel.dtos.usuarios.UserCreateDTO;
import com.remedios.amber.curso.dtos.usuarios.enums.UserRole;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="nome_usuario")
    private String nomeUsuario;
    private String password;

    @Enumerated(EnumType.STRING)
    private  UserRole role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nomeUsuario;
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
    public User(UserCreateDTO data, String senha) {
        this.name = data.nome();
        this.nomeUsuario = data.nomeUsuario();
        this.password = senha;
        this.role = UserRole.ROLE_ADMIN;
    }
}
