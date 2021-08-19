package com.myairlines.flightreservation.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, updatable = false, unique = true)
    private String reservationCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Ticket ticket;

    @OneToOne
    @JoinColumn
    private Passenger passenger;

    @Column(nullable = false)
    private String reservationStatus;
}
