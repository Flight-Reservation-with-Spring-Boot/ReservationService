package com.myairlines.flightreservation.DAO;

import com.myairlines.flightreservation.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight getFlightByNumber(Integer number);

    @Query("SELECT f from Flight f WHERE f.departureTime >= ?1 and f.departureTime < ?2")
    List<Flight> findFlightByDepartureTime(LocalDateTime departureDate, LocalDateTime departureDatePlus);

    @Query("SELECT f from Flight f WHERE f.departureAirport.code = ?1")
    List<Flight> findFlightsByDepartureAirport(String airportCode);
}
