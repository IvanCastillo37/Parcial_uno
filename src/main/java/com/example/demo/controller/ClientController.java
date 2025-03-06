package com.example.demo.controller;

import com.example.demo.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.example.demo.repository.ClientRepository;

@RestController
@RequestMapping("/clients") // Defines the base path for this controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository; // Injects the repository to interact with the database

    // Retrieves all clients from the database
    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Retrieves a specific client by ID
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        return clientRepository.findById(id);
    }

    // Saves a new client in the database
    @PostMapping
    public Client saveClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    // Updates an existing client by ID
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientActualizado) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setFirstName(clientActualizado.getFirstName());
                    client.setPhone(clientActualizado.getPhone());
                    return clientRepository.save(client);
                }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    // Deletes a client by ID
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }

}
