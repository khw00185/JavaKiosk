package com.example.kiosk2;

public class MenuItem <T extends Number> {
    private String name;
    private T price;
    private String description;

    public MenuItem(String name, T price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }


    public void print(){
        System.out.println( name + "   | W " + price + "   | " + description);
    }
}
