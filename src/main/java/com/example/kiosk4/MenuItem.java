package com.example.kiosk4;

public class MenuItem <T extends Number> {
    private String name;
    private T price;
    private String description;

    public MenuItem(String name, T price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public void print(){
        System.out.printf("%-20s | W %-5.1f | %s\n", name, price, description);
    }
}
