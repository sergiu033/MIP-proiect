package org.example.models;

import org.example.movierating.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    private Cinema cinema;

    @BeforeEach
    void setUp() {
        cinema = new Cinema("TestCinema");
    }

    @Test
    void testAddCustomer() {
        cinema.addCustomer("John", "Doe", LocalDate.of(1990, 1, 1));
        assertEquals(1, cinema.getCustomers().size());
        assertEquals("John", cinema.getCustomers().get(0).getFirstName());
    }

    @Test
    void testAddEmployee() {
        cinema.addEmployee("Jane", "Doe", LocalDate.of(1985, 5, 20));
        assertEquals(1, cinema.getEmployees().size());
        assertEquals("Jane", cinema.getEmployees().get(0).getFirstName());
    }

    @Test
    void testAddRoom() {
        cinema.addRoom(101, 50);
        assertEquals(1, cinema.getRooms().size());
        assertEquals(101, cinema.getRooms().get(0).getNumber());
    }

    @Test
    void testAddMovie() {
        cinema.addMovie("Inception", 148, Rating.PG_13);
        assertEquals(1, cinema.getMovies().size());
        assertEquals("Inception", cinema.getMovies().get(0).getTitle());
    }

    @Test
    void testDeleteCustomer() {
        cinema.addCustomer("John", "Doe", LocalDate.of(1990, 1, 1));
        String customerId = cinema.getCustomers().get(0).getId();
        cinema.deleteCustomer(customerId);
        assertTrue(cinema.getCustomers().isEmpty());
    }

    @Test
    void testDeleteEmployee() {
        cinema.addEmployee("Jane", "Doe", LocalDate.of(1985, 5, 20));
        String employeeId = cinema.getEmployees().get(0).getId();
        cinema.deleteEmployee(employeeId);
        assertTrue(cinema.getEmployees().isEmpty());
    }

    @Test
    void testDeleteRoom() {
        cinema.addRoom(101, 50);
        cinema.deleteRoom(101);
        assertTrue(cinema.getRooms().isEmpty());
    }

    @Test
    void testDeleteMovie() {
        cinema.addMovie("Inception", 148, Rating.PG_13);
        cinema.deleteMovie("Inception");
        assertTrue(cinema.getMovies().isEmpty());
    }

    @Test
    void testPrintMethods() {
        cinema.addCustomer("John", "Doe", LocalDate.of(1990, 1, 1));
        cinema.addEmployee("Jane", "Doe", LocalDate.of(1985, 5, 20));
        cinema.addMovie("Inception", 148, Rating.PG_13);
        cinema.addRoom(101, 50);

        assertDoesNotThrow(cinema::printCustomers);
        assertDoesNotThrow(cinema::printEmployees);
        assertDoesNotThrow(cinema::printMovies);
        assertDoesNotThrow(cinema::printRooms);
    }
}
