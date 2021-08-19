package com.myairlines.flightreservation.Service.Implementation;

import com.myairlines.flightreservation.DAO.FlightRepository;
import com.myairlines.flightreservation.DAO.ReservationRepository;
import com.myairlines.flightreservation.DAO.TicketRepository;
import com.myairlines.flightreservation.DTO.DTOAdaptors.ReservationDTOAdaptor;
import com.myairlines.flightreservation.DTO.DTOAdaptors.TicketDTOAdaptor;
import com.myairlines.flightreservation.DTO.ReservationDTO;
import com.myairlines.flightreservation.DTO.TicketDTO;
import com.myairlines.flightreservation.EnumClasses.ReservationStatus;
import com.myairlines.flightreservation.Model.Reservation;
import com.myairlines.flightreservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, TicketRepository ticketRepository, FlightRepository flightRepository) {
        this.reservationRepository = reservationRepository;
        this.ticketRepository = ticketRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public ReservationDTO makeReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationDTOAdaptor.getReservation(reservationDTO);
        reservationRepository.save(reservation);
        return reservationDTO;
    }

    @Override
    public ReservationDTO updateReservation(String reservationCode, ReservationDTO updatedReservationDTO) {
        Reservation updatedReservation = reservationRepository.getReservationByReservationCode(reservationCode);

        if (updatedReservationDTO.getReservationStatus() != null &&
                (
                        updatedReservationDTO.getReservationStatus().equalsIgnoreCase(String.valueOf(ReservationStatus.CANCELLED)) ||
                        updatedReservationDTO.getReservationStatus().equalsIgnoreCase(String.valueOf(ReservationStatus.PENDING)) ||
                        updatedReservationDTO.getReservationStatus().equalsIgnoreCase(String.valueOf(ReservationStatus.CONFIRMED))
                )) {
            updatedReservation.setReservationStatus(updatedReservationDTO.getReservationStatus());
        }
        reservationRepository.save(updatedReservation);
        return updatedReservationDTO;
    }

    @Override
    public List<ReservationDTO> getReservations(Optional<Integer> page) {
        Pageable pagination = PageRequest.of(page.orElse(0), 10);
        List<ReservationDTO> reservationDTOList = new ArrayList<>();

        for (Reservation reservation : reservationRepository.findAll(pagination)) {
            reservationDTOList.add(ReservationDTOAdaptor.getReservationDto(reservation));
        }

        return reservationDTOList;
    }

    @Override
    public ReservationDTO getReservationByCode(String reservationCode) {
        Reservation reservation = reservationRepository.getReservationByReservationCode(reservationCode);
        return ReservationDTOAdaptor.getReservationDto(reservation);
    }

    @Override
    public TicketDTO confirmReservation(String reservationCode, ReservationDTO reservationDTO, int flightNumber) {

        Reservation confirmedReservation = reservationRepository.getReservationByReservationCode(reservationCode);
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setFlight(flightRepository.getFlightByNumber(flightNumber));

        reservationDTO.setReservationStatus(String.valueOf(ReservationStatus.CONFIRMED));
        confirmedReservation.setReservationStatus(reservationDTO.getReservationStatus());

        reservationRepository.save(confirmedReservation);
        ticketRepository.save(TicketDTOAdaptor.getTicket(ticketDTO));

        return ticketDTO;
    }

    @Override
    public ReservationDTO cancelReservation(String reservationCode, ReservationDTO reservationDTO) {

        Reservation cancelledReservation = reservationRepository.getReservationByReservationCode(reservationCode);

        reservationDTO.setReservationStatus(String.valueOf(ReservationStatus.CANCELLED));
        cancelledReservation.setReservationStatus(reservationDTO.getReservationStatus());

        reservationRepository.save(cancelledReservation);

        return reservationDTO;
    }
}
