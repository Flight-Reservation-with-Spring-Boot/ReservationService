package com.myairlines.flightreservation.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, updatable = false, unique = true)
    @Size(min = 10, max = 10)
    @GeneratedValue
    private int number;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private Flight flight;
}
