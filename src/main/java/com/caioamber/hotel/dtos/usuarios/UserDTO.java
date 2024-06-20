package com.caioamber.hotel.dtos.usuarios;

import com.caioamber.hotel.entities.User;

public record UserDTO(Long id, String nome, String nomeUsuario) {

    public UserDTO(User user){
        this(user.getId(), user.getName(), user.getNomeUsuario());
    }
}
