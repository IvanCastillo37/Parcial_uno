package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated primary key
    private Long id;
    private String checkInDate; // Check-in date
    private String checkOutDate; // Check-out date

    @ManyToOne
    @JoinColumn(name = "client_id") // Links the reservation to a client
    private Client client;

    @ManyToOne
    @JoinColumn(name = "room_id") // Links the reservation to a room
    private Room room;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL) // One-to-One relation with Payment
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "employee_id") // Links the reservation to an employee
    private Employee employee;

    // Default constructor
    public Reservation() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
