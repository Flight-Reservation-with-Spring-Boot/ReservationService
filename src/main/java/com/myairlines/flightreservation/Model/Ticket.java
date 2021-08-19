package com.myairlines.flightreservation.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, updatable = false, unique = true)
    private int number;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private Flight flight;
}
