package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Station;
import com.bedu.tickets_sprbootv2.repository.StationRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class StationContoller {

    private StationRepository repository;

    public StationContoller(StationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/stations")
    public ResponseEntity<Void> crearEstacion(@Valid @RequestBody Station station){
        repository.save(station);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @GetMapping("/stations")
    public Iterable<Station> obtenerUsuarios(){
        return repository.findAll();
    }
}
