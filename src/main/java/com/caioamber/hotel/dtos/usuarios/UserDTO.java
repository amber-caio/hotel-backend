package com.caioamber.hotel.dtos.usuarios;

import com.caioamber.hotel.entities.Usuario;

public record UserDTO(Long id, String nome, String login) {
    public UserDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getLogin());
    }
}
