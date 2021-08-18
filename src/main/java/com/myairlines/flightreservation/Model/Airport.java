package com.myairlines.flightreservation.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class Airport {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    @Size(max = 3, min = 3, message = "Airport code Should be 3 characters!")
    private String code;

    @Embedded
    private Address address;
}
