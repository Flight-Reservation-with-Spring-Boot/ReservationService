package com.myairlines.flightreservation.Model;

import com.myairlines.flightreservation.Model.CustomeGenerator.MyGenerator;
import com.myairlines.flightreservation.EnumClasses.ReservationStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, updatable = false, unique = true)
    @Size(min = 7, max = 7)
    @GeneratedValue(generator = MyGenerator.generatorName)
    @GenericGenerator(name = MyGenerator.generatorName,
            strategy = "com.myairlines.flightreservation.Model.CustomeGenerator.MyGenerator")
    private String reservationCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Ticket ticket;

    @Column(nullable = false)
    private String reservationStatus;
}
