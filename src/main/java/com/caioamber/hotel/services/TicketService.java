package com.caioamber.hotel.services;

import com.caioamber.hotel.dtos.tickets.TicketCreateDTO;
import com.caioamber.hotel.dtos.tickets.TicketDTO;
import com.caioamber.hotel.entities.Ticket;
import com.caioamber.hotel.exceptions.NotFoundException;
import com.caioamber.hotel.repositories.CarroRepository;
import com.caioamber.hotel.repositories.HospedeRepository;
import com.caioamber.hotel.repositories.TicketRepository;
import com.caioamber.hotel.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository repository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private CarroRepository carroRepository;

    public TicketDTO cadastro(TicketCreateDTO data){

        if(hospedeRepository.findByCpf(data.cpfHospede()) == null){
            throw new NotFoundException("Visitant not found!");
        }

        vagaRepository.findById(data.numVaga()).orElseThrow(() -> new NotFoundException("Car space not found"));

        if (carroRepository.findByPlaca(data.placaCarro()) == null){
            throw new NotFoundException("Car not found!");
        }

        Ticket ticket = new Ticket(data);
        ticket.setFk_hospede(hospedeRepository.findByCpf(data.cpfHospede()));
        ticket.setFk_carro(carroRepository.findByPlaca(data.placaCarro()));
        ticket.setFk_vaga(vagaRepository.getReferenceById(data.numVaga()));

        repository.save(ticket);


        return new TicketDTO(ticket);
    }

    public List<TicketDTO> getAll(){
        return repository.findAllByStatusTrue().stream().map(TicketDTO::new).toList();
    }

    public TicketDTO getById(Long id){
        return new TicketDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Ticket not found")));
    }

    public TicketDTO alterarStatus(Long id, Boolean ativo){
        Ticket ticket = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Ticket not found!"));
        ticket.setStatus(ativo);
        this.repository.save(ticket);

        return new TicketDTO(ticket);
    }
}
