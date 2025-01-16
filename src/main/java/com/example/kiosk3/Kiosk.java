package com.example.kiosk3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                item.print();
            }
            System.out.println("0. 종료");

            try{
                int choice = scanner.nextInt();
                if(choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choice >0 && choice < menuItems.size()) {
                    System.out.print("선택하신 메뉴: ");
                    menuItems.get(choice-1).print();
                    System.out.println();
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            } catch (InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            }

        }
        scanner.close();
    }
}
