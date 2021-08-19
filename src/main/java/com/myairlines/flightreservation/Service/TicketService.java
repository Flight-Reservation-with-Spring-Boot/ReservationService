package com.myairlines.flightreservation.Service;

import com.myairlines.flightreservation.DTO.TicketDTO;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<TicketDTO> getAllTickets(Optional<Integer> page);
    TicketDTO getTicket(int ticketNumber);
}
