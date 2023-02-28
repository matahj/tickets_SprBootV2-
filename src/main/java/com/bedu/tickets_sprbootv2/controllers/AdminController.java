package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Admin;
import com.bedu.tickets_sprbootv2.repository.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class AdminController {
    private AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @PostMapping("/admins")
    public ResponseEntity<Void> crearAdmin(@Valid @RequestBody Admin admin){
        repository.save(admin);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @GetMapping("/admins")
    public Iterable<Admin> obtenerAdmins(){
        return repository.findAll();
    }
}
