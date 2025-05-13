package com.pluralsight;

import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        double cost = getOriginalCost();
        int currentYear = Year.now().getValue();
        int age = currentYear - year;
        double value = cost;

        if (age <= 3) {
            value -= cost * 0.03 * age;
        } else if (age <= 6) {
            value -= cost * 0.06 * age;
        } else if (age <= 10) {
            value -= cost * 0.08 * age;
        } else {
            value = 1000.00;
        }

        // Mileage penalty (unless Honda or Toyota)
        if (odometer > 100000 && !(makeModel.contains("Honda") || makeModel.contains("Toyota"))) {
            value *= 0.75; // Reduce by 25%
        }

        return Math.max(value, 0); // Avoid negative values
    }
}

