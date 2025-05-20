package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create a list of at least 10 people
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", "Smith", 30));
        people.add(new Person("Bob", "Johnson", 25));
        people.add(new Person("Charlie", "Brown", 40));
        people.add(new Person("David", "Lee", 19));
        people.add(new Person("Eve", "Martinez", 28));
        people.add(new Person("Frank", "Jones", 32));
        people.add(new Person("Grace", "Taylor", 45));
        people.add(new Person("Hannah", "Davis", 22));
        people.add(new Person("Ian", "Wilson", 34));
        people.add(new Person("Jane", "Clark", 27));

        // Step 2: Prompt the user for a name to search
        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        List<Person> matchingPeople = new ArrayList<>();

        for (Person person : people) {
            if (person.getFirstName().toLowerCase().equals(searchName) ||
                    person.getLastName().toLowerCase().equals(searchName)) {
                matchingPeople.add(person);
            }
        }
