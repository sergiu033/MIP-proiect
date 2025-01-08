package org.example.interfaces;

import org.example.movierating.Rating;

import java.io.IOException;
import java.time.LocalDate;

public interface ICinema {
    public void loadFiles() throws IOException;
    public void saveFiles() throws IOException;

    public void addCustomer(String firstName, String lastName, LocalDate birthDate);
    public void addEmployee(String firstName, String lastName, LocalDate birthDate);
    public void addRoom(int number, int capacity);
    public void addMovie(String title, int length, Rating rating);

    public void printCustomers();
    public void printEmployees();
    public void printRooms();
    public void printMovies();

    public void saveCustomers() throws IOException;
    public void saveEmployees() throws IOException;
    public void saveRooms() throws IOException;
    public void saveMovies() throws IOException;

    public void loadCustomers() throws IOException;
    public void loadEmployees() throws IOException;
    public void loadRooms() throws IOException;
    public void loadMovies() throws IOException;

    public void deleteCustomer(String customerId);
    public void deleteEmployee(String employeeId);
    public void deleteRoom(int roomNumber);
    public void deleteMovie(String title);

}
