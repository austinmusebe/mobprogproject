package com.example.mobprogproject;

import java.io.Serializable;

public class CartItem implements Serializable {
    private String name;
    private int quantity;
    private double price;

    public CartItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
