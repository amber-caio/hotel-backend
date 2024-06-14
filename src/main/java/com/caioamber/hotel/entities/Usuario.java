package com.caioamber.hotel.entities;

import com.caioamber.hotel.dtos.usuarios.UserCreateDTO;
import com.caioamber.hotel.dtos.usuarios.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name="Usuario")
@Entity(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Usuario(UserCreateDTO data, String senha){
        this.nome = data.nome();
        this.login = data.login();
        this.senha = senha;
        this.role = UserRole.ROLE_USER;
    }

    // Controle de acesso
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        if (this.role == UserRole.ROLE_ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN")
                , new SimpleGrantedAuthority("ROLE_USER"));
        else if (this.role == UserRole.ROLE_MANAGER) return List.of(new SimpleGrantedAuthority("ROLE_MANAGER"),
                new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
