package com.caioamber.hotel.security.services;

import com.caioamber.hotel.entities.User;
import com.caioamber.hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user = repository.findByUsername(username);

        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
