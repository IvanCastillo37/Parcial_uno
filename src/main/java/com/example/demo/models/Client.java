package com.example.demo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental primary key
    private long id;
    private String firstName; // Client's first name
    private String lastName;  // Client's last name
    private String phone;     // Client's phone number

    @OneToMany(mappedBy = "client") // A client can have multiple reservations
    private List<Reservation> reservations;

    //Default constructor
    public Client() {
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Reservation> getReservas() {
        return reservations;
    }

    public void setReservas(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
