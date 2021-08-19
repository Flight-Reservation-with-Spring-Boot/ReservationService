package com.myairlines.flightreservation.Service;

import com.myairlines.flightreservation.DTO.AirportDTO;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<AirportDTO> getAllAirports(Optional<Integer> page);

    AirportDTO addNewAirport(AirportDTO airportDTO);

    AirportDTO updateAirport(String airportCode, AirportDTO airportDTO);

    AirportDTO getAirportByCode(String airportCode);

    AirportDTO deleteAirport(String airportCode);
}
