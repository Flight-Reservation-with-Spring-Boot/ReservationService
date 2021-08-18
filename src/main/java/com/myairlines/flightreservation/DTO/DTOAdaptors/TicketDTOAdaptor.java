package com.myairlines.flightreservation.DTO.DTOAdaptors;

import com.myairlines.flightreservation.DTO.TicketDTO;
import com.myairlines.flightreservation.Model.Ticket;

public class TicketDTOAdaptor {
    public static Ticket getTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();

        ticket.setFlight(ticketDTO.getFlight());
        ticket.setNumber(ticketDTO.getNumber());

        return ticket;
    }

    public static TicketDTO getTicketDto(Ticket ticket) {
        TicketDTO ticketDto = new TicketDTO();

        ticketDto.setFlight(ticket.getFlight());
        ticketDto.setNumber(ticket.getNumber());

        return ticketDto;
    }
}
