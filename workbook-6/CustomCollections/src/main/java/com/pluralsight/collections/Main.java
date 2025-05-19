package com.pluralsight.collections;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Integer list test
        FixedList<Integer> numbers = new FixedList<>(3);
        numbers.add(10);
        numbers.add(3);
        numbers.add(92);
        numbers.add(43); // this should fail (list full)

        System.out.println("Number of items in 'numbers': " + numbers.getItems().size());
        System.out.println("Contents of 'numbers': " + numbers.getItems());


        FixedList<LocalDate> dates = new FixedList<>(2);
        dates.add(LocalDate.now());
        dates.add(LocalDate.now());


        // dates.add(15); // Invalid type (should fail to compile)

        System.out.println("Number of items in 'dates': " + dates.getItems().size());
        System.out.println("Contents of 'dates': " + dates.getItems());
    }
}

