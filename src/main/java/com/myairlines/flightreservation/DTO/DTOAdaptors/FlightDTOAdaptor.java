package com.myairlines.flightreservation.DTO.DTOAdaptors;

import com.myairlines.flightreservation.DAO.AirportRepository;
import com.myairlines.flightreservation.DTO.FlightDTO;
import com.myairlines.flightreservation.Model.Flight;

public class FlightDTOAdaptor {

    public static Flight getFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();

        flight.setNumber(flightDTO.getNumber());
        flight.setCapacity(flightDTO.getCapacity());
        flight.setDepartureAirport(flightDTO.getDepartureAirport());
        flight.setArrivalAirport(flightDTO.getArrivalAirport());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());
        flight.setFlightStatus(flightDTO.getFlightStatus());

        return flight;
    }

    public static FlightDTO getFlightDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setNumber(flight.getNumber());
        flightDTO.setCapacity(flight.getCapacity());
        flightDTO.setDepartureAirport(flight.getDepartureAirport());
        flightDTO.setDepartureTime(flight.getDepartureTime());
        flightDTO.setArrivalTime(flight.getArrivalTime());
        flightDTO.setFlightStatus(flight.getFlightStatus());

        return flightDTO;
    }
}
