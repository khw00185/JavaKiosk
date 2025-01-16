package com.example.kiosk3;

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
        System.out.println( name + "   | W " + price + "   | " + description);
    }
}
