package com.caioamber.hotel.security.services;

import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class HospedeDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private HospedeRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Hospede> hospede = repository.findByNomeUsuario(username);

        if(hospede.isPresent()) {
            return hospede.get();
        }
        throw new UsernameNotFoundException("User not found: " + username);

    }
}
