package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;


public class BlackJackGame {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("How many players will be playing? ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < numPlayers; i++){
            System.out.println("What is your name? ");
            String nameOfPlayer = scanner.nextLine();
            players.add(new Player(nameOfPlayer));
        }

        Deck deck  = new Deck();
        deck.shuffle();

        for (Player player : players) {
                player.hand.deal(deck.deal());
                player.hand.deal(deck.deal());
                player.hand.print();
        }

        Player bestPlayer = null;

        for (Player player : players) {
            if (player.getHand().getValue() > 21) continue; // skip busted players

            if (bestPlayer == null || player.compareTo(bestPlayer) > 0) {
                bestPlayer = player;
            }
        }
        if (bestPlayer != null) {
            System.out.println("Winner: " + bestPlayer.getName() + " with score: " + bestPlayer.getHand().getValue());
        } else {
            System.out.println("All players busted. No winner.");
        }



    }
}
