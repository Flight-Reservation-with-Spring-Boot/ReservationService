package com.myairlines.flightreservation.Controller;

import com.myairlines.flightreservation.DTO.FlightDTO;
import com.myairlines.flightreservation.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/flights")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getFlights(@RequestParam Optional<Integer> page) {
        return ResponseEntity.ok(flightService.getAllFlights(page));
    }

    @PostMapping
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO) {
        return ResponseEntity.ok(flightService.addFlight(flightDTO));
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> getByFlightNumber(@PathVariable("flightNumber") Integer flightNumber) {
        return ResponseEntity.ok(flightService.getByFlightNumber(flightNumber));
    }

    @PutMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> updateFlight(
            @Valid
            @PathVariable("flightNumber") Integer flightNumber,
            @RequestBody FlightDTO flightDTO
    ) {
        FlightDTO flight = flightService.updateFlight(flightNumber, flightDTO);
        return ResponseEntity.ok(flight);
    }

    @PatchMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> cancelFlight(
            @PathVariable("flightNumber") Integer flightNumber,
            @RequestBody FlightDTO flightDTO
    ) {
        FlightDTO flight = flightService.cancelFlight(
                flightNumber,
                flightDTO.getFlightStatus()
        );
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/specificDate")
    public ResponseEntity<List<FlightDTO>> getFlightsInSpecificDate(
            @RequestParam(value = "departureDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate
    ) {
        return ResponseEntity.ok(flightService.flightsInSpecificDate(departureDate));
    }

    @GetMapping("/flightFromAirport/{airportCode}")
    public ResponseEntity<List<FlightDTO>> getFlightsFromAirport(
            @PathVariable(value = "airportCode") String airportCode
    ) {
        return ResponseEntity.ok(flightService.findFlightsFromAirport(airportCode));
    }
}
