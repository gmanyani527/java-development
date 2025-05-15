package com.pluralsight;

public abstract class FixedAsset implements Valuable {
    protected String name;
    protected double value;

    public FixedAsset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
