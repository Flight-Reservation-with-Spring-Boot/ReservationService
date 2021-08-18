package com.myairlines.flightreservation.Model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false, updatable = false)
    @Size(min = 6, max = 6)
    @GeneratedValue
    private int number;

    @Column(nullable = false)
    private int capacity;

    @OneToOne @JoinColumn
    private Airport departureAirport;

    @OneToOne @JoinColumn
    private Airport arrivalAirport;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Column(nullable = false)
    private String flightStatus;
}
