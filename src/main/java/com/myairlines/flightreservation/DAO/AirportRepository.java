package com.myairlines.flightreservation.DAO;

import com.myairlines.flightreservation.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AirportRepository extends JpaRepository<Airport, Integer> {
    Airport findAirportByCode(String code);
    void deleteAirportByCode(String code);
}
