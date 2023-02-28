package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Bus;
import com.bedu.tickets_sprbootv2.models.Ticket;
import com.bedu.tickets_sprbootv2.repository.BusRepository;
import com.bedu.tickets_sprbootv2.repository.TicketRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class TicketController {
    private TicketRepository repository;

    public TicketController(TicketRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @PostMapping("/tickets")
    public ResponseEntity<Void> crearTicket(@Valid @RequestBody Ticket ticket){
        repository.save(ticket);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @GetMapping("/tickets")
    public Iterable<Ticket> obtenerTickets(){
        return repository.findAll();
    }
}
