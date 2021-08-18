package com.myairlines.flightreservation.DTO;

import com.myairlines.flightreservation.Model.Address;
import lombok.Data;

@Data
public class AirportDTO {
    private String name;
    private String code;
    private Address address;
}
