package com.myairlines.flightreservation.Service;

import com.myairlines.flightreservation.DTO.FlightDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<FlightDTO> getAllFlights(Optional<Integer> page);

    FlightDTO addFlight(FlightDTO flightDTO);

    FlightDTO getByFlightNumber(Integer flightNumber);

    FlightDTO updateFlight(Integer flightNumber,
                           FlightDTO flightDTO);

    FlightDTO cancelFlight(Integer flightNumber, String flightStatus);

    List<FlightDTO> flightsInSpecificDate(LocalDate departureDate);

    List<FlightDTO> findFlightsFromAirport(String airportCode);
}