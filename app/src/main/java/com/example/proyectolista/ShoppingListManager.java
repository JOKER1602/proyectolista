package com.example.proyectolista;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    private static List<String> shoppingItems = new ArrayList<>();

    public static List<String> getShoppingItems() {
        return shoppingItems;
    }

    public static void addShoppingItem(String itemDetails) {
        shoppingItems.add(itemDetails);
    }

    public static void clearShoppingItems() {
        shoppingItems.clear();
    }
}
