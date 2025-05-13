package com.pluralsight;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        // Create a House object
        ArrayList<Asset> assets = new ArrayList<>();
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
        assets.add(new House(
                "My House",
                "2018-04-10",
                240000,
                "456 Oak Street",
                1,
                1800,
                4000
        ));

        assets.add(new House(
                "Vacation Home",
                "2021-07-20",
                320000,
                "789 Beach Road",
                2,
                2200,
                6000
        ));

        // Add Vehicles
        assets.add(new Vehicle(
                "Tom's Truck",
                "2020-01-15",
                35000,
                "Ford F-150",
                2019,
                120000
        ));

        assets.add(new Vehicle(
                "My Sedan",
                "2022-05-30",
                27000,
                "Honda Accord",
                2022,
                15000
        ));

        // Loop through and display basic info
        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: $" + asset.getOriginalCost());
            System.out.println("Current Value: $" + asset.getValue());

            // Display values
            System.out.println("House Description: " + house.getDescription());
            System.out.println("House Value: $" + house.getValue());

            System.out.println();

            System.out.println("Vehicle Description: " + vehicle.getDescription());
            System.out.println("Vehicle Value: $" + vehicle.getValue());
        }
    }
}
