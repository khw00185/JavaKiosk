package com.example.kiosk5.item;

public class MenuItem extends AbstractItem {

    public MenuItem(String name, double price, String description) {
        super(name, price, description);
    }
    @Override
    public void print(){
        System.out.printf("%-20s | W %-5.1f | %s\n", getName(), getPrice(), getDescription());
    }
}
