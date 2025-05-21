package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;



public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        List<Person> people = List.of(
                new Person("Alice", "Smith", 30),
                new Person("Bob", "Johnson", 25),
                new Person("Charlie", "Brown", 40),
                new Person("David", "Lee", 19),
                new Person("Eve", "Martinez", 28),
                new Person("Frank", "Jones", 32),
                new Person("Grace", "Taylor", 45),
                new Person("Hannah", "Davis", 22),
                new Person("Ian", "Wilson", 34),
                new Person("Jane", "Clark", 27)
        );


        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().trim();

        List<Person> matchingPeople = people.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(searchName) ||
                        p.getLastName().equalsIgnoreCase(searchName))
                .collect(Collectors.toList());

        System.out.println("\nMatching people:");
        if (matchingPeople.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            matchingPeople.forEach(System.out::println);
        }


        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);


        int oldestAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        int youngestAge = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);


        Person oldestPerson = people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);

        Person youngestPerson = people.stream()
                .min(Comparator.comparingInt(Person::getAge))
                .orElse(null);


        System.out.printf("\nAverage Age: %.2f\n", averageAge);
        System.out.println("Oldest Age: " + oldestAge);
        System.out.println("Youngest Age: " + youngestAge);

        if (oldestPerson != null) {
            System.out.println("Oldest Person: " + oldestPerson);
        }
        if (youngestPerson != null) {
            System.out.println("Youngest Person: " + youngestPerson);
        }
    }
}
