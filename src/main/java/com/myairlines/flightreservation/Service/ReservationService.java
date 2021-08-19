package com.myairlines.flightreservation.Service;

import com.myairlines.flightreservation.DTO.ReservationDTO;
import com.myairlines.flightreservation.DTO.TicketDTO;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    ReservationDTO makeReservation(ReservationDTO reservationDTO);
    ReservationDTO updateReservation(String reservationCode, ReservationDTO reservationDTO);
    List<ReservationDTO> getReservations(Optional<Integer> page);
    ReservationDTO getReservationByCode(String code);
    TicketDTO confirmReservation(String reservationCode, ReservationDTO reservationDTO, int flightNumber);
    ReservationDTO cancelReservation(String reservationCode, ReservationDTO reservationDTO);
}
