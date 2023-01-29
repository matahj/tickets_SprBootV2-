package com.bedu.tickets_sprbootv2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "The departure date is required")
    @Column(nullable = false)
    private LocalDate departure;

    @NotNull(message = "The departure time is required")
    @Column(nullable = false)
    private LocalTime depTime;

    @Positive(message = "The preice must be greater than zero")
    @Column(nullable = false)
    private double price;

    @NotNull(message = "The origin is required")
    @ManyToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id", nullable = false)
    private Station origin;

    @NotNull(message = "The destinity is required")
    @ManyToOne
    @JoinColumn(name = "destinity_id", referencedColumnName = "id", nullable = false)
    private Station destinity;

    @NotNull(message = "The driver is required")
    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
    private Driver driver;

    @NotNull(message = "The bus is required")
    @ManyToOne
    @JoinColumn(name = "bus_id", referencedColumnName = "id", nullable = false)
    private Bus bus;

    /*
    POST desde postman:
    {
        "departure": "2023-02-22T17:45:00.000",
        "price": 1225.45,
        "origin": "http://localhost:8080/stations/1",
        "destinity": "http://localhost:8080/stations/2",
        "driver": "http://localhost:8080/drivers/1",
        "bus":"http://localhost:8080/buses/1"
    }
    */
}
