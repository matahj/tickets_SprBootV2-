package com.bedu.tickets_sprbootv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

@Data
@Entity
//@RestResource //en lugar de @RepositoryRestResource en UserRepository
//@RestResource(exported = false) //para que no se creen los servicios
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Invalid mail")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "The password is required")
    //@JsonIgnore
    @Column(nullable = false)
    private String password;
}
