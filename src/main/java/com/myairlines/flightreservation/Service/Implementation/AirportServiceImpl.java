package com.myairlines.flightreservation.Service.Implementation;

import com.myairlines.flightreservation.DAO.AirportRepository;
import com.myairlines.flightreservation.DTO.AirportDTO;
import com.myairlines.flightreservation.DTO.DTOAdaptors.AirportDTOAdaptor;
import com.myairlines.flightreservation.Model.Airport;
import com.myairlines.flightreservation.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<AirportDTO> getAllAirports(Optional<Integer> page) {
        Pageable pagination = PageRequest.of(page.orElse(0), 10);
        List<AirportDTO> airportDTOList = new ArrayList<>();
        for (Airport airport : airportRepository.findAll(pagination)) {
            airportDTOList.add(AirportDTOAdaptor.getAirportDto(airport));
        }
        return airportDTOList;
    }

    @Override
    public AirportDTO addNewAirport(AirportDTO airportDTO) {
        Airport airport = AirportDTOAdaptor.getAirport(airportDTO);
        airportRepository.save(airport);
        return airportDTO;
    }

    @Override
    public AirportDTO updateAirport(String airportCode, AirportDTO updatedAirportDTO) {
        Airport updatedAirport = airportRepository.findAirportByCode(airportCode);
        if (updatedAirportDTO.getName() != null &&
                updatedAirportDTO.getName().length() > 1 &&
                !Objects.equals(updatedAirport.getName(), updatedAirportDTO.getName())) {
            updatedAirport.setName(updatedAirportDTO.getName());
        }

        if (updatedAirportDTO.getAddress() != null) {
            updatedAirport.setAddress(updatedAirportDTO.getAddress());
        }

        airportRepository.save(updatedAirport);
        return updatedAirportDTO;
    }

    @Override
    public AirportDTO getAirportByCode(String airportCode) {
        Airport airport = airportRepository.findAirportByCode(airportCode);
        return AirportDTOAdaptor.getAirportDto(airport);
    }

    @Override
    public AirportDTO deleteAirport(String airportCode) {
        Airport airport = airportRepository.findAirportByCode(airportCode);
        AirportDTO airportDTO = AirportDTOAdaptor.getAirportDto(airport);

        airportRepository.deleteAirportByCode(airportCode);
        return airportDTO;
    }
}
