package com.example.kiosk5;

import com.example.kiosk5.item.AbstractItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Menu <T extends AbstractItem> {
    private String category;
    private final List<T> menuItems= new ArrayList<>();


    public Menu(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    public int getMenuItemSize(){
        return menuItems.size();
    }

    public List<T> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(T menuItem) {
        menuItems.add(menuItem);
    }


    public void printMenu() {
        System.out.println("[ "+category+" MENU ]");
        IntStream.range(0, menuItems.size())
                        .forEach(i -> {
                            System.out.print((i+1)+". ");
                            menuItems.get(i).print();
                        });
        System.out.println("0. 종료");
    }
}
