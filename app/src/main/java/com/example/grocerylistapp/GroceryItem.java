package com.example.grocerylistapp;

import java.io.Serializable;

class GroceryItem implements Serializable {
    private String itemName;
    private double itemPrice;

    GroceryItem(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    String getItemName() {
        return itemName;
    }

    double getItemPrice() {
        return itemPrice;
    }
}
