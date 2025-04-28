package com.pluralsight;

import java.util.Scanner;
import java.util.Random;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String[] quotes = {

                "The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
                "Success is not final, failure is not fatal: it is the courage to continue that counts. - Winston Churchill",
                "Believe you can and you're halfway there. - Theodore Roosevelt",
                "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
                "Do not wait to strike till the iron is hot, but make it hot by striking. - William Butler Yeats",
                "It does not matter how slowly you go as long as you do not stop. - Confucius",
                "Everything you’ve ever wanted is on the other side of fear. - George Addair",
                "Hardships often prepare ordinary people for an extraordinary destiny. - C.S. Lewis",
                "Happiness is not something ready made. It comes from your own actions. - Dalai Lama",
                "In the middle of every difficulty lies opportunity. - Albert Einstein"
        };

        boolean isRunning = true;
        while (isRunning) {
            boolean found = false;
            try {
                System.out.println("Would you like to choose or Randomize? (Select 1 or 2)");
                int answer1 = scan.nextInt();
                if (answer1 == 1) {
                    System.out.println("Enter a number between 1 and 10: ");
                    int input = scan.nextInt();
                    scan.nextLine();

                    for (int i = 0; i < quotes.length; i++) {
                        if (input == i + 1) {
                            System.out.println(quotes[i]);
                            found = true;
                            break;
                        }
                    }
                } else if (answer1 == 2) {
                    int randomIndex = random.nextInt(10); // 0 to 9
                    System.out.println("Random Quote:");
                    System.out.println(quotes[randomIndex]);
                }

                if (!found) {
                    System.out.println("Number does not exist");
                }


            } catch (Exception e) {
                System.out.println("That number does not exist");
            }


            System.out.println("Would you like to see another quote?");
            String answer = scan.nextLine();

            if (!answer.equalsIgnoreCase("yes")) {
                isRunning = false;
            }
        }
    }


}
