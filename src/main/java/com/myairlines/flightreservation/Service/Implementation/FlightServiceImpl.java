package com.myairlines.flightreservation.Service.Implementation;

import com.myairlines.flightreservation.DAO.FlightRepository;
import com.myairlines.flightreservation.DTO.DTOAdaptors.FlightDTOAdaptor;
import com.myairlines.flightreservation.DTO.FlightDTO;
import com.myairlines.flightreservation.EnumClasses.FlightStatus;
import com.myairlines.flightreservation.Model.Flight;
import com.myairlines.flightreservation.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    @Override
    public List<FlightDTO> getAllFlights(Optional<Integer> page) {
        Pageable pagination = PageRequest.of(page.orElse(0), 10);
        List<FlightDTO> flightDTOList = new ArrayList<>();
        for (Flight flight : flightRepository.findAll(pagination)) {
            flightDTOList.add(FlightDTOAdaptor.getFlightDTO(flight));
        }
        return flightDTOList;
    }

    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        Flight flight = FlightDTOAdaptor.getFlight(flightDTO);

        if (
                flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.AVAILABLE)) ||
                        flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.DELAYED)) ||
                        flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.CANCELLED))
        ) {
            flightRepository.save(flight);
        } else {
            throw new IllegalStateException("Incorrect Flight Status!!!");
        }

        return flightDTO;
    }

    @Override
    public FlightDTO getByFlightNumber(Integer flightNumber) {
        Flight flight = flightRepository.getFlightByNumber(flightNumber);
        return FlightDTOAdaptor.getFlightDTO(flight);
    }

    @Override
    public FlightDTO updateFlight(Integer flightNumber, FlightDTO updatedFlightDTO) {
        Flight updatedFlight = flightRepository.getFlightByNumber(flightNumber);

        if (updatedFlightDTO.getArrivalAirport() != null) {
            updatedFlight.setArrivalAirport(updatedFlightDTO.getArrivalAirport());
        }

        if (updatedFlightDTO.getDepartureAirport() != null) {
            updatedFlight.setDepartureAirport(updatedFlightDTO.getDepartureAirport());
        }

        if (updatedFlightDTO.getFlightStatus() != null &&
                (
                        updatedFlightDTO.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.AVAILABLE)) ||
                                updatedFlightDTO.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.DELAYED)) ||
                                updatedFlightDTO.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.CANCELLED))
                )) {
            updatedFlight.setFlightStatus(updatedFlightDTO.getFlightStatus());
        }

        if (updatedFlightDTO.getCapacity() > 0) {
            updatedFlight.setCapacity(updatedFlightDTO.getCapacity());
        }

        if (updatedFlightDTO.getArrivalTime() != null) {
            updatedFlight.setArrivalTime(updatedFlightDTO.getArrivalTime());
        }

        if (updatedFlightDTO.getDepartureTime() != null) {
            updatedFlight.setDepartureTime(updatedFlightDTO.getDepartureTime());
        }

        flightRepository.save(updatedFlight);

        return updatedFlightDTO;
    }

    @Override
    public FlightDTO cancelFlight(Integer flightNumber, String flightStatus) {
        Flight cancelledFlight = flightRepository.getFlightByNumber(flightNumber);
        if (flightStatus != null &&
                flightStatus.equalsIgnoreCase(String.valueOf(FlightStatus.CANCELLED))) {
            cancelledFlight.setFlightStatus(flightStatus);
        } else {
            throw new IllegalStateException("Incorrect Flight Status!!!");
        }

        flightRepository.save(cancelledFlight);

        return FlightDTOAdaptor.getFlightDTO(cancelledFlight);
    }

    @Override
    public List<FlightDTO> flightsInSpecificDate(LocalDate departureDate) {
        List<FlightDTO> flightDTOList = new ArrayList<>();

        LocalDateTime localDateTime = departureDate.atStartOfDay();
        LocalDateTime localDateTimePlus = departureDate.plusDays(1).atStartOfDay();

        for (Flight flight : flightRepository.findFlightByDepartureTime(localDateTime, localDateTimePlus)) {
            flightDTOList.add(FlightDTOAdaptor.getFlightDTO(flight));
        }

        if (flightDTOList.size() > 0)
            return flightDTOList;
        else {
            throw new ResourceAccessException("There are no flights in the specified date!!!");
        }
    }

    @Override
    public List<FlightDTO> findFlightsFromAirport(String airportCode) {
        List<FlightDTO> flightDTOList = new ArrayList<>();

        for (Flight flight : flightRepository.findFlightsByDepartureAirport(airportCode)) {
            flightDTOList.add(FlightDTOAdaptor.getFlightDTO(flight));
        }

        return flightDTOList;
    }
}
