package com.myairlines.flightreservation.DTO;

import com.myairlines.flightreservation.Model.Airport;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDTO {
    private int number;
    private int capacity;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightStatus;
}
