package com.bedu.tickets_sprbootv2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "The phone is required")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "The address is required")
    @Column(nullable = false)
    private String address;

    @NotNull(message = "The station is required")
    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "id", nullable = false)
    private Station station;
    /*
    POST en postman
    {
        "name": "conductor1",
        "phone": "12345",
        "address": "dir conductor 1",
        "station": "http://localhost:8080/stations/1"
    }
    */
    /*
    {
        "name": "conductor1",
        "phone": "12345",
        "address": "dir conductor 1",
        "station": {"id":1}
    }
    */
}
