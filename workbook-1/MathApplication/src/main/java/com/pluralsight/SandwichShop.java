package com.pluralsight;

import java.util.Scanner;


public class SandwichShop{
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            Scanner scanner = new Scanner(System.in);

            double price = 0.0;
            String answer = null;

            System.out.println("Welcome, what size would you like your sandwich to be? ");

            answer = scanner.nextLine();

            if (answer.equals("Regular") || answer.equals("regular")) {
                price = 5.45;
            } else if (answer.equalsIgnoreCase("large")) {
                price = 8.95;
            } else {
                System.out.println("Invalid Input");
                isRunning = false;
            }

            System.out.println("What's your age ");

            int age = scanner.nextInt();

            if (age <= 17) {
                double discount = price * .10;
                price -= discount;
                String formattedAmount = String.format("Price: $%.2f\n", price);
                System.out.println(formattedAmount);
                isRunning = false;
            }
             else if( age > 17 && age < 65 ){
                String formattedAmount = String.format("Price: $%.2f\n", price);
                System.out.println(formattedAmount);
                isRunning = false;
            }
              else if (age >= 65) {
                double discount = price * .20;
                price -= discount;
                String formattedAmount = String.format("Price: $%.2f\n", price);
                System.out.println(formattedAmount);
                isRunning = false;
            }
              else{
                  System.out.println("Invalid Input");
                  isRunning = false;
            }

        }
    }
}


