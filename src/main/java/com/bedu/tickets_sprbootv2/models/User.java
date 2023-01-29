package com.bedu.tickets_sprbootv2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class User {
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
