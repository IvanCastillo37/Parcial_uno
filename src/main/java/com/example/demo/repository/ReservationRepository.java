package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    // Finds all reservations by client ID
    List<Reservation> findByClientId(Long clientId);
}