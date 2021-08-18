package com.myairlines.flightreservation.DAO;

import com.myairlines.flightreservation.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
