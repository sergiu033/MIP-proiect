package org.example.models;

import java.time.LocalDate;
import java.util.Random;

public class Employee extends Person {
    Random rand = new Random();

    public Employee() {}

    public Employee(String firstName, String lastName, LocalDate birthDate) {
        this.id = "E0" + Integer.toString(rand.nextInt(1000,9999));
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
