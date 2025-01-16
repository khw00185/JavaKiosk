package com.example.kiosk5.item;

public class CartItem extends AbstractItem{

    public CartItem(String name, double price, String description, int quantity) {
        super(name, price, description, quantity);
    }

    @Override
    public void print(){
        System.out.printf("%-20s | W %-5.1f | %s | %d개 \n", getName(), getPrice(), getDescription(), getQuantity());
    }
}
