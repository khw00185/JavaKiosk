package com.example.kiosk5.item;

public interface ItemInterface {
    String getName();
    double getPrice();
    String getDescription();
    int getQuantity();
    void setQuantity(int quantity);
    void print();
}
