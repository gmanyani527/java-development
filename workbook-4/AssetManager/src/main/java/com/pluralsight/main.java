package com.pluralsight;

public class main {
    public static void main(String[] args) {
        // Create a House object
        House house = new House(
                "Family Home",
                "2020-06-15",
                250000.00,
                "123 Maple Street",
                2,             // good
                2000,          // square feet
                5000           // lot size
        );

        // Create a Vehicle object
        Vehicle vehicle = new Vehicle(
                "Sedan Car",
                "2019-03-10",
                30000.00,
                "Toyota Camry",
                2018,
                105000         // odometer
        );

        // Display values
        System.out.println("House Description: " + house.getDescription());
        System.out.println("House Value: $" + house.getValue());

        System.out.println();

        System.out.println("Vehicle Description: " + vehicle.getDescription());
        System.out.println("Vehicle Value: $" + vehicle.getValue());
    }
}
