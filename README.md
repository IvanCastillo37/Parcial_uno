# Parcial_uno
Parcial primer corte Desarrollo de apps empresariales
The system manages a hotel, allowing the administration of customers, rooms, reservations, payments, and employees through a REST API built with Spring Boot, JPA, and MySQL.

Controllers (@RestController) → Handle HTTP requests for CRUD operations.
Repositories (@Repository) → Connect to the database using JpaRepository.
Entities (@Entity) → Represent tables and their relationships in the database.
Docker Compose → Configures MySQL and Adminer for database management.

Workflow:
Register customers and rooms.
Create reservations linking customers and rooms.
Register payments associated with reservations.
Retrieve and manage information using the API.

The system runs on port 4500, the database on 5500, and Adminer on 8000.
