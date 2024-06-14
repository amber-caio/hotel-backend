package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.token.TokenDTO;
import com.caioamber.hotel.dtos.usuarios.*;
import com.caioamber.hotel.entities.Usuario;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.UsuarioRepository;
import com.caioamber.hotel.security.filters.SecurityFilter;
import com.caioamber.hotel.security.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private AuthenticationManager manager;
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private SecurityFilter securityFilter;

    public TokenDTO efetuarLogin(UserAuthenticationDTO data){
        UserDetails user = repository.findByLogin(data.login());

        if(user == null){
            throw new BadCredentialsException("Usuário inexistente ou senha inválida. Tente novamente!");
        }

        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(data.login(), data.senha()));

        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return new TokenDTO(tokenJWT);
    }

    public UserDTO register(UserCreateDTO data){
        if(repository.findByLogin(data.login()) != null){
            throw new IllegalArgumentException("User already exists!");
        }

        Usuario usuario = new Usuario(data, passwordEncoder.encode(data.senha()));
        repository.save(usuario);

        return new UserDTO(usuario);
    }

    public List<UserDTO> getAll(){
        return repository.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO setPrivilege(Long id, UserRoleDTO data){
        Usuario usuario = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));
        usuario.setRole(data.role());

        return new UserDTO(usuario);
    }
}
