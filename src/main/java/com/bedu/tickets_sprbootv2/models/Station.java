package com.bedu.tickets_sprbootv2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The city is required")
    @Column(nullable = false)
    private String city;

    @NotBlank(message = "The address is required")
    @Column(nullable = false)
    private String address;
}
