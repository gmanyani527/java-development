package com.pluralsight.collections;

import java.util.ArrayList;

import java.util.List;

public class FixedList<T> {
    private List<T> items;
    private int maxSize;

   
    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    // Add item if maxSize not reached
    public void add(T item) {
        if (items.size() < maxSize) {
            items.add(item);
        } else {
            System.out.println("Cannot add more items. List has reached its maximum size of " + maxSize);
        }
    }

    // Return all items
    public List<T> getItems() {
        return items;
    }
}

