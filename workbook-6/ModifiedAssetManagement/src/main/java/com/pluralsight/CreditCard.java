package com.pluralsight;

public class CreditCard implements Valuable {
    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void charge(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void pay(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public double getValue() {
        return -balance;  // Since it's debt, the value is negative
    }
}
