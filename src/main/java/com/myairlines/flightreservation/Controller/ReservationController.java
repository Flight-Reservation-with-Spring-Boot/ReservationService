package com.myairlines.flightreservation.Controller;

import com.myairlines.flightreservation.DTO.ReservationDTO;
import com.myairlines.flightreservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<?> getAllReservations(@RequestParam Optional<Integer> page) {
        return ResponseEntity.ok(reservationService.getReservations(page));
    }

    @PostMapping
    public ResponseEntity<?> makeReservation(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.ok(reservationService.makeReservation(reservationDTO));
    }

    @GetMapping("/{reservationCode}")
    public ResponseEntity<?> getReservationByCode(@PathVariable("reservationCode") String reservationCode) {
        return ResponseEntity.ok(reservationService.getReservationByCode(reservationCode));
    }

    @PatchMapping ("/{reservationCode}/cancel")
    public ResponseEntity<?> cancelReservation(@PathVariable("reservationCode") String reservationCode, @RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.ok(reservationService.cancelReservation(reservationCode, reservationDTO));
    }

    @PatchMapping ("/{reservationCode}/confirm/{flightNumber}")
    public ResponseEntity<?> confirmReservation(@PathVariable("reservationCode") String reservationCode, @RequestBody ReservationDTO reservationDTO, @PathVariable("flightNumber")
            Integer flightNumber) {
        return ResponseEntity.ok(reservationService.confirmReservation(reservationCode, reservationDTO, flightNumber));
    }

    @PutMapping("/{reservationCode}")
    public ResponseEntity<?> updateReservation(@PathVariable("reservationCode") String reservationCode, @RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.ok(reservationService.updateReservation(reservationCode, reservationDTO));
    }
}
