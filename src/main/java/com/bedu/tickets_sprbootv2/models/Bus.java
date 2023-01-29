package com.bedu.tickets_sprbootv2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The plate is required")
    @Column(nullable = false)
    private String plate;

    @NotBlank(message = "The kind is required")
    @Column(nullable = false)
    private String kind;

    @NotNull(message = "The station is required")
    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "id", nullable = false)
    private Station station;
}
