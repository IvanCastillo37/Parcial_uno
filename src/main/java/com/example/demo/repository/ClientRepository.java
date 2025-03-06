package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Finds clients by their name (should use String, not Long)
    List<Client> findByNome(String name);
}
