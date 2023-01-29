package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.Admin;
import com.bedu.tickets_sprbootv2.models.User;
import com.bedu.tickets_sprbootv2.repository.AdminRepository;
import com.bedu.tickets_sprbootv2.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class AdminController {
    private AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/admins")
    public ResponseEntity<Void> crearAdmin(@Valid @RequestBody Admin admin){
        repository.save(admin);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @GetMapping("/admins")
    public Iterable<Admin> obtenerAdmins(){
        return repository.findAll();
    }
}
