package com.bedu.tickets_sprbootv2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Positive(message = "The seat number must be greater than 0.")
    @Min(value = 1, message = "The seat number must be greater than 1.")
    @Max(value = 40, message = "The seat number must be less than 40.")
    @Column(nullable = false)
    private int seat;

    @Positive(message = "The preice must be greater than zero")
    @Column(nullable = false)
    private double price;

    @NotBlank(message = "The description is required")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "The trip is required")
    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id", nullable = false)
    private Trip trip;

    @NotNull(message = "The user is required")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
}
