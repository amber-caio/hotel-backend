package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.usuarios.UserCreateDTO;
import com.caioamber.hotel.dtos.usuarios.UserDTO;
import com.caioamber.hotel.entities.User;
import com.caioamber.hotel.repositories.UserRepository;
import com.caioamber.hotel.security.SecurityFilter;
import com.caioamber.hotel.security.dtos.AuthenticationDTO;
import com.caioamber.hotel.security.dtos.TokenJWTDTO;
import com.caioamber.hotel.security.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void saveUser(User user){
        this.repository.save(user);
    }

    public Object getByUsername(String username){
        Optional<User> user = repository.findByUsername(username);

        if(user.isPresent()){
            return  user.get();
        }
        throw new UsernameNotFoundException("User not found " + username);
    }

}
