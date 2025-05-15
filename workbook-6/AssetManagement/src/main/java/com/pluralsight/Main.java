package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Portfolio myPortfolio = new Portfolio("My Net Worth", "Ash");

        // Fixed Assets
        myPortfolio.add(new House("My Home", 300000, 2005, 2000, 3));
        myPortfolio.add(new Jewelry("Diamond Ring", 5000, 24));
        myPortfolio.add(new Gold("Gold Bar", 7000, 1.5));

        // Liquid Accounts
        myPortfolio.add(new BankAccount("Chase Checking", "123456", 2500));
        myPortfolio.add(new CreditCard("Visa", "654321", 1200)); // This will reduce net worth

        // Print Total
        myPortfolio.printAssets();
        System.out.println("Total Net Worth: $" + myPortfolio.getValue());
    }
}

