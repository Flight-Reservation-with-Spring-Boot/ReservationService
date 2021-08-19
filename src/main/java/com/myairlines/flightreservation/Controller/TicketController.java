package com.myairlines.flightreservation.Controller;

import com.myairlines.flightreservation.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<?> getAllReservations(@RequestParam Optional<Integer> page) {
        return ResponseEntity.ok(ticketService.getAllTickets(page));
    }

    @GetMapping("/{ticketNumber}")
    public ResponseEntity<?> getReservationByCode(@PathVariable("ticketNumber") int ticketNumber) {
        return ResponseEntity.ok(ticketService.getTicket(ticketNumber));
    }
}
