package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public void add(Valuable valuable) {
        assets.add(valuable);
    }

    public double getValue() {
        double total = 0.0;
        for (Valuable asset : assets) {
            total += asset.getValue();
        }
        return total;
    }

    // Optional: to display portfolio contents
    public void printAssets() {
        for (Valuable asset : assets) {
            System.out.println(asset.getClass().getSimpleName() + " - Value: $" + asset.getValue());
        }
    }
}
