package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Admin;
import com.bedu.tickets_sprbootv2.models.Bus;
import com.bedu.tickets_sprbootv2.repository.AdminRepository;
import com.bedu.tickets_sprbootv2.repository.BusRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class BusController {
    private BusRepository repository;

    public BusController(BusRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/buses")
    public ResponseEntity<Void> crearBus(@Valid @RequestBody Bus bus){
        repository.save(bus);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @GetMapping("/buses")
    public Iterable<Bus> obtenerBuses(){
        return repository.findAll();
    }
}
