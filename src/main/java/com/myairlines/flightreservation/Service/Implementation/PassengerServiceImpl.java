package com.myairlines.flightreservation.Service.Implementation;

import com.myairlines.flightreservation.DAO.PassengerRepository;
import com.myairlines.flightreservation.DTO.DTOAdaptors.PassengerDTOAdaptor;
import com.myairlines.flightreservation.DTO.PassengerDTO;
import com.myairlines.flightreservation.Model.Passenger;
import com.myairlines.flightreservation.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    @Override
    public List<PassengerDTO> getPassengers(Optional<Integer> page) {
        Pageable pagination = PageRequest.of(page.orElse(0), 10);
        List<PassengerDTO> passengerDTOList = new ArrayList<>();

        for (Passenger passenger : passengerRepository.findAll(pagination)) {
            passengerDTOList.add(PassengerDTOAdaptor.getPassengerDto(passenger));
        }

        return passengerDTOList;
    }

    @Override
    public PassengerDTO getPassenger(int id) {
        Passenger passenger = passengerRepository.getById(id);
        return PassengerDTOAdaptor.getPassengerDto(passenger);
    }

    @Override
    public PassengerDTO updatePassenger(int id, PassengerDTO passengerDTO) {
        Passenger updatedPassenger = passengerRepository.getById(id);

        if (passengerDTO.getFullName() != null) {
            updatedPassenger.setFullName(passengerDTO.getFullName());
        }

        if (passengerDTO.getBirthDate() != null) {
            updatedPassenger.setBirthDate(passengerDTO.getBirthDate());
        }

        if (passengerDTO.getAddress() != null) {
            updatedPassenger.setAddress(passengerDTO.getAddress());
        }

        passengerRepository.save(updatedPassenger);

        return passengerDTO;
    }

    @Override
    public PassengerDTO deletePassenger(int id) {

        Passenger deletedPassenger = passengerRepository.getById(id);
        PassengerDTO passengerDTO = PassengerDTOAdaptor.getPassengerDto(deletedPassenger);
        passengerRepository.delete(deletedPassenger);

        return passengerDTO;
    }
}
