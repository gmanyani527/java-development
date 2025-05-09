package com.pluralsight;

public class Player {
    String name;
    Hand hand;


    public Player(String name){
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int compareTo(Player other){
        int thisScore = this.getHand().getValue();
        int otherScore = other.getHand().getValue();

        if (thisScore > otherScore) return 1;
        else if(thisScore < otherScore) return -1;
        else return 0;
    }
}
