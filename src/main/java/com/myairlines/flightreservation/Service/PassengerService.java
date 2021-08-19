package com.myairlines.flightreservation.Service;

import com.myairlines.flightreservation.DTO.PassengerDTO;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    List<PassengerDTO> getPassengers(Optional<Integer> page);
    PassengerDTO getPassenger(int id);
    PassengerDTO updatePassenger(int id, PassengerDTO passengerDTO);
    PassengerDTO deletePassenger(int id);
}
