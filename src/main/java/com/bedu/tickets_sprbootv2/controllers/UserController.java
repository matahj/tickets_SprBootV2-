package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.User;
import com.bedu.tickets_sprbootv2.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UserController {
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/users")
    public ResponseEntity<Void> crearUsuario(@Valid @RequestBody User user){
        repository.save(user);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @GetMapping("/users")
    public Iterable<User> obtenerUsuarios(){
        return repository.findAll();
    }
}
