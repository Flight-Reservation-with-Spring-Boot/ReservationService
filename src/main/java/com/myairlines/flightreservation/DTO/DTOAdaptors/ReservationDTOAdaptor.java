package com.myairlines.flightreservation.DTO.DTOAdaptors;

import com.myairlines.flightreservation.DTO.ReservationDTO;
import com.myairlines.flightreservation.Model.Reservation;

public class ReservationDTOAdaptor {
    public static Reservation getReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();

        reservation.setReservationCode(reservationDTO.getReservationCode());
        reservation.setReservationStatus(reservationDTO.getReservationStatus());
        reservation.setTicket(reservationDTO.getTicket());
        reservation.setPassenger(reservationDTO.getPassenger());

        return reservation;
    }

    public static ReservationDTO getReservationDto(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setReservationCode(reservation.getReservationCode());
        reservationDTO.setReservationStatus(reservation.getReservationStatus());
        reservationDTO.setTicket(reservation.getTicket());
        reservationDTO.setPassenger(reservation.getPassenger());

        return reservationDTO;
    }
}
