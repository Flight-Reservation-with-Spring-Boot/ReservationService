package com.myairlines.flightreservation.DTO;

import com.myairlines.flightreservation.Model.Address;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PassengerDTO {
    private String fullName;
    private LocalDate birthDate;
    private Address address;
}
