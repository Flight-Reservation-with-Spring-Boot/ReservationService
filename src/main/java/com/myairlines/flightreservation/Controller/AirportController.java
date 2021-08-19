package com.myairlines.flightreservation.Controller;

import com.myairlines.flightreservation.DTO.AirportDTO;
import com.myairlines.flightreservation.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private final AirportService service;

    @Autowired
    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllAirports(@RequestParam Optional<Integer> page)  {
        return ResponseEntity.ok(service.getAllAirports(page));
    }

    @GetMapping("/{airportCode}")
    public ResponseEntity<?> getAirportByCode(@PathVariable("airportCode") String airportCode) {
        return ResponseEntity.ok(service.getAirportByCode(airportCode));
    }

    @PostMapping
    public ResponseEntity<?> addNewAirport(@RequestBody AirportDTO airportDTO) {
        return ResponseEntity.ok(service.addNewAirport(airportDTO));
    }

    @PutMapping("/{airportCode}")
    public ResponseEntity<?> updateAirport(@PathVariable("airportCode") String airportCode, @RequestBody AirportDTO airportDTO) {
        return ResponseEntity.ok(service.updateAirport(airportCode, airportDTO));
    }

    @DeleteMapping("/{airportCode}")
    public ResponseEntity<?> deleteAirport(@PathVariable("airportCode") String airportCode) {
        return ResponseEntity.ok(service.deleteAirport(airportCode));
    }
}
