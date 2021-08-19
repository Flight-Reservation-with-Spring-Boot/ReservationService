package com.myairlines.flightreservation.DTO.DTOAdaptors;

import com.myairlines.flightreservation.DTO.PassengerDTO;
import com.myairlines.flightreservation.Model.Passenger;

public class PassengerDTOAdaptor {
    public static Passenger getPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger();

        passenger.setAddress(passengerDTO.getAddress());
        passenger.setBirthDate(passengerDTO.getBirthDate());
        passenger.setFullName(passengerDTO.getFullName());

        return passenger;
    }

    public static PassengerDTO getPassengerDto(Passenger passenger) {
        PassengerDTO passengerDTO = new PassengerDTO();

        passengerDTO.setAddress(passenger.getAddress());
        passengerDTO.setBirthDate(passenger.getBirthDate());
        passengerDTO.setFullName(passenger.getFullName());

        return passengerDTO;
    }
}
