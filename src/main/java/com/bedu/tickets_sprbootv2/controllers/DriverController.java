package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Driver;
import com.bedu.tickets_sprbootv2.repository.DriverRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class DriverController {
    private DriverRepository repository;

    public DriverController(DriverRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @PostMapping("/drivers")
    public ResponseEntity<Void> crearDriver(@Valid @RequestBody Driver driver){
        repository.save(driver);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @GetMapping("/drivers")
    public Iterable<Driver> obtenerDriavers(){
        return repository.findAll();
    }
}
