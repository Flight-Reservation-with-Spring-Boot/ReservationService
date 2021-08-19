package com.myairlines.flightreservation.Controller;

import com.myairlines.flightreservation.DTO.PassengerDTO;
import com.myairlines.flightreservation.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPassengers(@RequestParam Optional<Integer> page) {
        return ResponseEntity.ok(passengerService.getPassengers(page));
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<?> getPassenger(@PathVariable("passengerId") int passengerId) {
        return ResponseEntity.ok(passengerService.getPassenger(passengerId));
    }

    @PostMapping
    public ResponseEntity<?> addPassenger(@RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.ok(passengerService.addPassenger(passengerDTO));
    }

    @PutMapping("/{passengerId}")
    public ResponseEntity<?> updatePassenger(@PathVariable("passengerId") int passengerId, @RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.ok(passengerService.updatePassenger(passengerId, passengerDTO));
    }

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<?> deletePassenger(@PathVariable("passengerId") int passengerId) {
        return ResponseEntity.ok(passengerService.deletePassenger(passengerId));
    }
}
