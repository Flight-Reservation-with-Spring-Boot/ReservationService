package com.myairlines.flightreservation.DTO;

import com.myairlines.flightreservation.Model.Airport;

import java.time.LocalDateTime;

public class FlightDTO {
    private int id;
    private int number;
    private int capacity;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightStatus;
}
