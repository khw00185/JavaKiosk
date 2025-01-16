package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String category;
    private final List<MenuItem> menuItems;


    public Menu(String category) {
        this.category = category;
        this.menuItems = new ArrayList<>();
    }


    public String getCategory() {
        return category;
    }
    public int getMenuItemSize(){
        return menuItems.size();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }


    public void printMenu() {
        System.out.println("[ "+category+" MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.print(i+1 + ". ");
            item.print();
        }
        System.out.println("0. 종료");
    }
}
