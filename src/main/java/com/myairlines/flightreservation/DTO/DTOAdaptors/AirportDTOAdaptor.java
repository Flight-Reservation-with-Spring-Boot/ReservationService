package com.myairlines.flightreservation.DTO.DTOAdaptors;

import com.myairlines.flightreservation.DTO.AirportDTO;
import com.myairlines.flightreservation.Model.Airport;

public class AirportDTOAdaptor {
    public static Airport getAirport(AirportDTO airportDTO) {
        Airport airport = new Airport();
        airport.setAddress(airportDTO.getAddress());
        airport.setCode(airportDTO.getCode());
        airport.setName(airportDTO.getName());

        return airport;
    }

    public static AirportDTO getAirportDto(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setAddress(airport.getAddress());
        airportDTO.setCode(airport.getCode());
        airportDTO.setName(airport.getName());

        return airportDTO;
    }
}
