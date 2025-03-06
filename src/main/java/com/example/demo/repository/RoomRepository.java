package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    // Finds rooms by type
    List<Room> findByType(String type);
}