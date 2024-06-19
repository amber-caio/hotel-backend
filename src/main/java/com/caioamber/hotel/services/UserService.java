package com.caioamber.hotel.services;

import com.caioamber.hotel.entities.User;
import com.caioamber.hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


}
