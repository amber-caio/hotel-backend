package com.caioamber.hotel.security.services;

import com.caioamber.hotel.dtos.usuarios.UserCreateDTO;
import com.caioamber.hotel.dtos.usuarios.UserDTO;
import com.caioamber.hotel.entities.User;
import com.caioamber.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDTO register(UserCreateDTO data){
        User user = new User(data, passwordEncoder.encode(data.senha()));

        userService.saveUser(user);

        return new UserDTO(user);
    }
}
