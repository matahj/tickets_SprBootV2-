package com.bedu.tickets_sprbootv2.controllers;

import com.bedu.tickets_sprbootv2.models.User;
import com.bedu.tickets_sprbootv2.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
public class UserController {
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @PostMapping("/users")
    public ResponseEntity<Void> crearUsuario(@Valid @RequestBody User user){
        repository.save(user);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @CrossOrigin(origins = {"http://localhost:4200","https://resilient-kitten-27a2e6.netlify.app"})
    @GetMapping("/users")
    public Iterable<User> obtenerUsuarios(){
        return repository.findAll();
    }

    /*@GetMapping("/users/usuarios/{id}")
    public ResponseEntity<User> obtenerUsuarioId(@PathVariable("id") long usrId){
        if(usrId>10){//No exist (404 - NotFound)

            //No regresa ningún mensaje
            //return ResponseEntity.notFound().build();

            //Regresa el mensaje por defecto
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user does not exist.");
        }
        if(usrId > 5){
            //Confidencial (403 - Forbiden)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You do not have access permission");
        }

        User user = new User();
        user.setName("Usuario");
        user.setEmail("usuario@usuario.com");

        return ResponseEntity.ok(user);
    }*/

    /*@PostMapping("/users/usuarios")
    public ResponseEntity<Void> crearUnUsuario(@Valid @RequestBody User user){
        return ResponseEntity.created(URI.create("")).build();
    }*/
}
