package com.myairlines.flightreservation.DTO;

import com.myairlines.flightreservation.Model.Passenger;
import com.myairlines.flightreservation.Model.Ticket;
import lombok.Data;

@Data
public class ReservationDTO {
    private String reservationCode;
    private Passenger passenger;
    private Ticket ticket;
    private String reservationStatus;
}
