package com.example.kiosk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MenuItem buger1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem buger2 = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem buger3 = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem buger4 = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(buger1);
        menuItems.add(buger2);
        menuItems.add(buger3);
        menuItems.add(buger4);

        Scanner scanner = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");
        int i =1;
        for(MenuItem menuItem : menuItems) {
            System.out.print(i++ +".");
            menuItem.print();
        }
        System.out.println("0. 종료      | 종료");
        int choice = scanner.nextInt();
        System.out.println();

        if(choice == 0) {
            System.out.println("프로그램을 종료합니다.");
        }
        else if(choice == 1) {
            menuItems.get(0).print();
        }
        else if(choice == 2) {
            menuItems.get(1).print();
        }
        else if(choice == 3) {
            menuItems.get(2).print();
        }
        else if(choice == 4) {
            menuItems.get(3).print();
        }
    }
}