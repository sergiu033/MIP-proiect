package org.example.models;

import org.example.movierating.Rating;
import org.example.jsonparsing.JsonParser;
import org.example.interfaces.ICinema;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cinema implements ICinema {
    private JsonParser parser = new JsonParser();
    private String fileCustomers;
    private String fileEmployees;
    private String fileMovies;
    private String fileRooms;

    private String cinemaName;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();

    public Cinema(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void loadFiles() throws IOException {
        fileCustomers =  cinemaName + "Customer.json";
        fileEmployees = cinemaName + "Employee.json";
        fileMovies = cinemaName + "Movie.json";
        fileRooms = cinemaName + "Room.json";

        loadCustomers();
        loadEmployees();
        loadMovies();
        loadRooms();
    }

    public void saveFiles() throws IOException {
        saveCustomers();
        saveEmployees();
        saveMovies();
        saveRooms();
    }

    public void addCustomer(String firstName, String lastName, LocalDate birthDate) {
        customers.add(new Customer(firstName, lastName, birthDate));
        System.out.println("Customer added");
    }

    public void addEmployee(String firstName, String lastName, LocalDate birthDate) {
        employees.add(new Employee(firstName, lastName, birthDate));
        System.out.println("Employee added");
    }

    public void addRoom(int number, int capacity) {
        rooms.add(new Room(number, capacity));
        System.out.println("Room added.");
    }

    public void addMovie(String title, int length, Rating rating) {
        movies.add(new Movie(title, length, rating));
        System.out.println("Movie added.");
    }

    public void printCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public void printRooms() {
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    public void printMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }
    }

    public void saveCustomers() throws IOException {
        parser.writeListToFile(customers, fileCustomers);
    }

    public void saveEmployees() throws IOException {
        parser.writeListToFile(employees, fileEmployees);
    }

    public void saveMovies() throws IOException {
        parser.writeListToFile(movies, fileMovies);
    }

    public void saveRooms() throws IOException {
        parser.writeListToFile(rooms, fileRooms);
    }

    public void loadCustomers() throws IOException {
        customers = parser.readListFromFile(Customer.class, fileCustomers);
    }

    public void loadEmployees() throws IOException {
        employees = parser.readListFromFile(Employee.class, fileEmployees);
    }

    public void loadMovies() throws IOException {
        movies = parser.readListFromFile(Movie.class, fileMovies);
    }

    public void loadRooms() throws IOException {
        rooms = parser.readListFromFile(Room.class, fileRooms);
    }

    public void deleteCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                customers.remove(customer);
                System.out.println("Customer removed");
                break;
            }
        }
    }

    public void deleteEmployee(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                employees.remove(employee);
                System.out.println("Employee removed");
                break;
            }
        }
    }

    public void deleteRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                rooms.remove(room);
                System.out.println("Room removed");
                break;
            }
        }
    }

    public void deleteMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                movies.remove(movie);
                System.out.println("Movie removed");
                break;
            }
        }
    }
}
