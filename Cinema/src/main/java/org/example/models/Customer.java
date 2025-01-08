package org.example.models;

import java.time.LocalDate;
import java.util.Random;

public class Customer extends Person {
    Random rand = new Random();

    public Customer() {}

    public Customer(String firstName, String lastName, LocalDate birthDate) {
        this.id = "C0" + Integer.toString(rand.nextInt(1000,9999));
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
