package com.caioamber.hotel.security.services;

import com.caioamber.hotel.dtos.hospedes.HospedeCreateDTO;
import com.caioamber.hotel.dtos.hospedes.HospedeDTO;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private HospedeService hospedeService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public HospedeDTO registerGuest(HospedeCreateDTO data){
        Hospede hospede = new Hospede(data, passwordEncoder.encode(data.senha()));
        hospedeService.saveHospede(hospede);

        return new HospedeDTO(hospede);
    }
}
