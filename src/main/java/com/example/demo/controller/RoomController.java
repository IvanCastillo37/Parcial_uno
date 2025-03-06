package com.example.demo.controller;

import com.example.demo.models.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habitaciones")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;// Injects the repository to interact with the database

    // Retrieves all rooms from the database
    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Retrieves a specific room by ID
    @GetMapping("/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id) {
        return roomRepository.findById(id);
    }

    // Saves a new room in the database
    @PostMapping
    public Room saveRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    // Updates an existing room by ID
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room roomActualizada) {
        return roomRepository.findById(id)
                .map(room -> {
                    room.setNumber(roomActualizada.getNumber());
                    room.setType(roomActualizada.getType());
                    room.setPrice(roomActualizada.getPrice());
                    return roomRepository.save(room);
                }).orElseThrow(() -> new RuntimeException("Rom not found"));
    }

    // Deletes a room by ID
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
    }

}
