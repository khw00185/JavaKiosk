package com.example.kiosk4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int categoryChoice, menuChoice;
        while (true) {
            System.out.println("[ MAIN MENU ] ");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i+1 + ". " +menus.get(i).getCategory());
            }
            System.out.println("0. 종료");

            while(true) {
                try {
                    categoryChoice = scanner.nextInt();
                    if(categoryChoice == 0) {
                        System.out.println("종료");
                        return;
                    } else if(categoryChoice > 0 && categoryChoice <= this.menus.size()) {
                        menus.get(categoryChoice-1).printMenu();
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                    scanner.nextLine();
                }
            }

            while(true) {
                try {
                    menuChoice = scanner.nextInt();
                    if(menuChoice == 0) {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    } else if (menuChoice >0 && menuChoice <= menus.get(categoryChoice-1).getMenuItemSize()) {
                        System.out.print("선택하신 메뉴: ");
                        MenuItem menuItem = menus.get(categoryChoice-1).getMenuItems().get(menuChoice - 1);
                        menuItem.print();
                        System.out.println();
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                    scanner.nextLine();
                }
            }
        }
    }
}
