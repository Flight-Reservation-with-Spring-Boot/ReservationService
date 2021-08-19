package com.myairlines.flightreservation.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Embedded
    private Address address;
}
