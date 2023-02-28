package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Admin;
import com.bedu.tickets_sprbootv2.models.Bus;
import com.bedu.tickets_sprbootv2.repository.AdminRepository;
import com.bedu.tickets_sprbootv2.repository.BusRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class BusController {
    private BusRepository repository;

    public BusController(BusRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @PostMapping("/buses")
    public ResponseEntity<Void> crearBus(@Valid @RequestBody Bus bus){
        repository.save(bus);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @GetMapping("/buses")
    public Iterable<Bus> obtenerBuses(){
        return repository.findAll();
    }
}
