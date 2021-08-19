package com.myairlines.flightreservation.Service.Implementation;

import com.myairlines.flightreservation.DAO.TicketRepository;
import com.myairlines.flightreservation.DTO.DTOAdaptors.TicketDTOAdaptor;
import com.myairlines.flightreservation.DTO.TicketDTO;
import com.myairlines.flightreservation.Model.Ticket;
import com.myairlines.flightreservation.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDTO> getAllTickets(Optional<Integer> page) {
        Pageable pagination = PageRequest.of(page.orElse(0), 10);
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        for (Ticket ticket : ticketRepository.findAll(pagination)) {
            ticketDTOList.add(TicketDTOAdaptor.getTicketDto(ticket));
        }

        return ticketDTOList;
    }

    @Override
    public TicketDTO getTicket(int ticketNumber) {
        Ticket ticket = ticketRepository.getByNumber(ticketNumber);
        return TicketDTOAdaptor.getTicketDto(ticket);
    }
}
