package com.caioamber.hotel.security.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    @Autowired
    private HospedeService hospedeService;

    @Autowired
    private AuthenticationService authenticationService;


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public HospedeDTO register(HospedeCreateDTO data){
        Hospede hospede = new Hospede(data, passwordEncoder.encode(data.senha()));

        hospedeService.cadastro(new HospedeCreateDTO(data.nome(), data.cpf(), data.idade(), data.nomeUsuario(), data.senha()));

        return new HospedeDTO(hospede);
    }
}
