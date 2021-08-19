package com.myairlines.flightreservation.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false, updatable = false)
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
