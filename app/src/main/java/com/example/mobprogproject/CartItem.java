package com.example.mobprogproject;

import java.io.Serializable;

public class CartItem implements Serializable {
    String name;
    int quantity;
    double price;

    public CartItem(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }


}
