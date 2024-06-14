package com.caioamber.hotel.controllers;

import com.caioamber.hotel.dtos.token.TokenDTO;
import com.caioamber.hotel.dtos.usuarios.UserAuthenticationDTO;
import com.caioamber.hotel.dtos.usuarios.UserCreateDTO;
import com.caioamber.hotel.dtos.usuarios.UserDTO;
import com.caioamber.hotel.dtos.usuarios.UserRoleDTO;
import com.caioamber.hotel.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    @Operation(summary = "Logar Usuário",
            description ="Logar Usuário",
            tags = {"Usuários"})
    @Transactional
    public ResponseEntity<TokenDTO> efetuarLogin(@RequestBody @Valid UserAuthenticationDTO data){
        return new ResponseEntity<>(service.efetuarLogin(data), HttpStatus.OK);
    }

    @PostMapping("/register")
    @Operation(summary = "Registrar Usuário",
            description ="Registrar Usuário",
            tags = {"Usuários"})
    @Transactional
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserCreateDTO data, UriComponentsBuilder uriBuilder){
        UserDTO user = service.register(data);
        URI uri = uriBuilder.path("/auth/{id}").buildAndExpand(user.id()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping
    @Operation(summary = "Listar Usuários",
            description ="Listar Usuários",
            tags = {"Usuários"})
    public ResponseEntity<List<UserDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/privilege/{id}")
    @Operation(summary = "Setar como Admin",
            description ="Setar como Admin",
            tags = {"Usuários"})
    @Transactional
    public ResponseEntity<UserDTO> putPrivilegeAdmin(@PathVariable Long id, @RequestBody UserRoleDTO data){
        return new ResponseEntity<>(service.setPrivilege(id, data), HttpStatus.OK);
    }
}
