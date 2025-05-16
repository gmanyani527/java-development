package com.pluralsight;

public class AssetManager {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio("My Portfolio", "Wardah");

        portfolio.add(new House("My House", "2018-01-01", 240000, "456 Oak Street", 2, 1800, 4000));
        portfolio.add(new Vehicle("Tom's Truck", "2020-01-15", 35000, "Ford F-150", 2019, 120000));
        portfolio.add(new Cash("Emergency Cash", "2023-05-01", 5000));

        System.out.println("Total Portfolio Value: $" + portfolio.getValue());

        Valuable most = portfolio.getMostValuable();
        System.out.println("Most Valuable: $" + most.getValue());

        Valuable least = portfolio.getLeastValuable();
        System.out.println("Least Valuable: $" + least.getValue());
    }
}

