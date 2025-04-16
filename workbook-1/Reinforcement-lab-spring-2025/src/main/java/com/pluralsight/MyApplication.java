package com.pluralsight;

import java.util.Scanner;
public class MyApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Name: " + name);
        System.out.print("Age: " + age);

        if(age >= 10){
            System.out.println("You are old enough to vote");
        } else {
            System.out.println("Your are not old enough to vote");
        }
    }
}
