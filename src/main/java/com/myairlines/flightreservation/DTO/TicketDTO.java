package com.myairlines.flightreservation.DTO;

import com.myairlines.flightreservation.Model.Flight;
import lombok.Data;

@Data
public class TicketDTO {
    private int number;
    private Flight flight;
}
