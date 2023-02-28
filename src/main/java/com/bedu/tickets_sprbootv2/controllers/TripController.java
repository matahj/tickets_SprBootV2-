package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Trip;
import com.bedu.tickets_sprbootv2.repository.TripRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class TripController {
    private TripRepository repository;

    public TripController(TripRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @PostMapping("/trips")
    public ResponseEntity<Void> crearTrip(@Valid @RequestBody Trip trip){
        repository.save(trip);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @GetMapping("/trips")
    public Iterable<Trip> obtenerTrip(){
        return repository.findAll();
    }
}
