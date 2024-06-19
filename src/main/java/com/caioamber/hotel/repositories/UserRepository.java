package com.caioamber.hotel.repositories;

import com.caioamber.hotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Long, User> {
    Optional<User> findByUsername(String username);
}
