package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Driver;
import com.bedu.tickets_sprbootv2.repository.DriverRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class DriverController {
    private DriverRepository repository;

    public DriverController(DriverRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/drivers")
    public ResponseEntity<Void> crearDriver(@Valid @RequestBody Driver driver){
        repository.save(driver);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @GetMapping("/drivers")
    public Iterable<Driver> obtenerDriavers(){
        return repository.findAll();
    }
}
