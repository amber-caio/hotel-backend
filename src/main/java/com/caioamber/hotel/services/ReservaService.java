package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.reservas.ReservaCreateDTO;
import com.caioamber.hotel.dtos.reservas.ReservaDTO;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.entities.Reserva;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.HospedeRepository;
import com.caioamber.hotel.repositories.QuartoRepository;
import com.caioamber.hotel.repositories.ReservaRepository;
import com.caioamber.hotel.security.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private AuthenticationService authenticationService;

    public ReservaDTO cadastrar(ReservaCreateDTO data){
        quartoRepository.findById(data.id_quarto()).orElseThrow(() -> new NotFoundException("Room not found!"));

        if(hospedeRepository.findByCpf(data.cpf()) == null){
            throw new NotFoundException("Visitant not found!");
        }

        Reserva reserva = new Reserva(data);
        reserva.setFk_quarto(quartoRepository.getReferenceById(data.id_quarto()));
        reserva.setFk_hospede(hospedeRepository.findByCpf(data.cpf()));

        repository.save(reserva);

        return new ReservaDTO(reserva);
    }

    public List<ReservaDTO> getAll(){
        return repository.findAllByStatusTrue().stream().map(ReservaDTO::new).toList();
    }

    public ReservaDTO getById(Long id){
        return new ReservaDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Reservation not found!")));
    }

    public ReservaDTO alterarStatus(Long id, Boolean status){
        Reserva reserva = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Reservation not found!"));
        reserva.setStatus(status);
        repository.save(reserva);
        return new ReservaDTO(reserva);
    }

//    public ReservaDTO getAllByUsername(){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = userDetails.getUsername();
//
//        return new ReservaDTO(repository.findByFk_Hospede((Hospede) userDetails));
//    }
}
