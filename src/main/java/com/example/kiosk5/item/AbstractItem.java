package com.example.kiosk5.item;

public abstract class AbstractItem implements ItemInterface {
    private String name;
    private double price;
    private String description;
    private int quantity=0;

    //MenuItem 생성자, menuItem에도 재고 기능이 추가될 경우 삭제
    public AbstractItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    //CartItem 생성자
    public AbstractItem(String name, double price, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void print();
}
