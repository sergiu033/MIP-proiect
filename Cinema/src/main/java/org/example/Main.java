package org.example;

import org.example.jsonparsing.JsonParser;
import org.example.models.*;
import org.example.movierating.Rating;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Cinema cinema = new Cinema("cinemaOne");
        cinema.loadFiles();

        System.out.println("Choose an option:");
        System.out.println("1. Show all movies");
        System.out.println("2. Show all cinema rooms");
        System.out.println("3. Show all customers");
        System.out.println("4. Show all employees");
        System.out.println("5. Add a movie");
        System.out.println("6. Add a room");
        System.out.println("7. Add a customer");
        System.out.println("8. Add a employee");
        System.out.println("9. Delete a movie");
        System.out.println("10. Delete a room");
        System.out.println("11. Delete a customer");
        System.out.println("12. Delete a employee");
        System.out.println("0. Exit");

        boolean running  = true;

        while (running) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    cinema.printMovies();
                    break;
                }
                case 2: {
                    cinema.printRooms();
                    break;
                }
                case 3: {
                    cinema.printCustomers();
                    break;
                }
                case 4: {
                    cinema.printEmployees();
                    break;
                }
                case 5: {
                    System.out.println("Enter the title: ");
                    String title = scanner.next();
                    System.out.println("Enter the length: ");
                    int length = scanner.nextInt();
                    System.out.println("Enter the movie rating (G/PG/PG_13/R/NC_17): ");
                    Rating rating = Rating.valueOf(scanner.next());
                    cinema.addMovie(title, length, rating);
                    break;
                }
                case 6: {
                    System.out.println("Enter the room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.println("Enter the number of seats: ");
                    int seats = scanner.nextInt();
                    cinema.addRoom(roomNumber, seats);
                    break;
                }
                case 7: {
                    System.out.println("Enter the customer first name: ");
                    String customerFirstName = scanner.next();
                    System.out.println("Enter the customer last name: ");
                    String customerLastName = scanner.next();
                    System.out.println("Enter the customer birth date (YYYY-MM-DD): ");
                    LocalDate birthDate = LocalDate.parse(scanner.next());
                    cinema.addCustomer(customerFirstName, customerLastName, birthDate);
                    break;
                }
                case 8: {
                    System.out.println("Enter the employee first name: ");
                    String employeeFirstName = scanner.next();
                    System.out.println("Enter the employee last name: ");
                    String employeeLastName = scanner.next();
                    System.out.println("Enter the employee birth date (YYYY-MM-DD): ");
                    LocalDate birthDate = LocalDate.parse(scanner.next());
                    cinema.addEmployee(employeeFirstName, employeeLastName, birthDate);
                    break;
                }
                case 9: {
                    System.out.println("Enter the movie's title: ");
                    String movieTitle = scanner.next();
                    cinema.deleteMovie(movieTitle);
                    break;
                }
                case 10: {
                    System.out.println("Enter the room number: ");
                    int roomNumber = scanner.nextInt();
                    cinema.deleteRoom(roomNumber);
                    break;
                }
                case 11: {
                    System.out.println("Enter the customer ID: ");
                    String customerID = scanner.next();
                    cinema.deleteCustomer(customerID);
                    break;
                }
                case 12: {
                    System.out.println("Enter the employee ID: ");
                    String employeeID = scanner.next();
                    cinema.deleteEmployee(employeeID);
                    break;
                }
                case 0: {
                    running = false;
                    cinema.saveFiles();
                    break;
                }
            }
        }
    }
}