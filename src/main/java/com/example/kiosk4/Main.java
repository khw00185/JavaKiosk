package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu burgerMenu = new Menu("Burger");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));


        Menu drinkMenu = new Menu("Drink");
        drinkMenu.addMenuItem(new MenuItem("Coke", 2.5, "콜라"));
        drinkMenu.addMenuItem(new MenuItem("Lemonade", 3.0, "레모네이드"));
        drinkMenu.addMenuItem(new MenuItem("Beer", 5.0, "맥주"));

        List<Menu> menus = new ArrayList<>();
        menus.add(burgerMenu);
        menus.add(drinkMenu);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();


    }
}